package com.example.pfeprojectbackend.auth;

/*
import com.example.pfeprojectbackend.config.Jwtservice;
import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.entities.Role;
import com.example.pfeprojectbackend.repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthenticationService {

    @Autowired
    private  EmployeRepository employeRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    private final Jwtservice jwtservice;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = Employe.builder()
                //.username(request.getName())
                .employeeId(request.getEmpolyeeId())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .identifiant(request.getIdentifiant())
              //  .comments(request.getComment())
                //.notification(request.getNotification())



                .build();

        employeRepository.save(user);

        var jwtToken = jwtservice.generateToken(user);
    return AuthenticationResponse.builder()
            .token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );


        var user = employeRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtservice.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken).build(); }
}
*/