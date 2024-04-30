package com.example.pfeprojectbackend.newJWT;

import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.newJWT.security.JwtService;
import com.example.pfeprojectbackend.repository.EmployeRepository;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final EmployeRepository employeRepository;

    private final TokenRepository tokenRepository;

    private final EmailService emailService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private String activationUrl="http://localhost:4200/activate-account";



    public void register(RegistrartionRequest request) throws MessagingException {

        var userRole = roleRepository.findByName("USER")
                .orElseThrow(()-> new IllegalStateException("ROLE USER was not found"));
        var user = Employe.builder()
                .username(request.getUsername())
                .identifiant(request.getIdentifiant())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .enabled(false)
                .roles(List.of(userRole))
                .build();

        employeRepository.save(user);
        sendValidationEmail(user); 
        
        
    }




  public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var claims = new HashMap<String, Object>();
        var user = ((Employe) auth.getPrincipal());
        claims.put("fullName", user.getUsername());

        var jwtToken = jwtService.generateToken(claims, (Employe) auth.getPrincipal());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Transactional
    public void activateAccount(String token) throws MessagingException {


        Token savedToken = tokenRepository.findByToken(token)
                // todo exception has to be defined
                .orElseThrow(() -> new RuntimeException("Invalid token"));
        if (LocalDateTime.now().isAfter(savedToken.getExpiredAt())) {
            sendValidationEmail(savedToken.getEmploye());
            throw new RuntimeException("Activation token has expired. A new token has been send to the same email address");
        }

        var user = employeRepository.findById(savedToken.getEmploye().getEmployeeId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setEnabled(true);
        employeRepository.save(user);

        savedToken.setValidateAt(LocalDateTime.now());
        tokenRepository.save(savedToken);


    }



    private String generateAndSaveActivationToken(Employe user) {

        // Generate a token
        String generatedToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiredAt(LocalDateTime.now().plusMinutes(15))
                .employe(user)
                .build();
        tokenRepository.save(token);

        return generatedToken;
    }



    private void sendValidationEmail(Employe user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);

        emailService.sendEmail(
                user.getEmail(),
                user.getUsername(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Account activation"
        );
    }






    private String generateActivationCode(int length) {

        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();

        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }

        return codeBuilder.toString();
    }

}

