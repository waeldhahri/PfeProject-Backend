package com.example.pfeprojectbackend.timeClockSystem;

import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.repository.EmployeRepository;
import com.example.pfeprojectbackend.service.IServiceEmploye;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@Data
public class SessionController {

    @Autowired
    private final SessionService sessionService;

    @Autowired
    private final IServiceEmploye serviceEmploye;

    @Autowired
    private final SessionRepository sessionRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @PostMapping("/login/{employee_Id}")
    public ResponseEntity<Long> login(@PathVariable Long employee_Id) {
        // Fetch user from the database
        Employe employe =  employeRepository.findById(employee_Id).orElse(null);

        if (employe == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Create a new session for login
        Session session = sessionService.createSession(employe);

        return ResponseEntity.ok(session.getId());
    }

    @PutMapping("/logout/{sessionId}")
    public ResponseEntity<Long> logout(@PathVariable Long sessionId) {
        // Fetch session from the database
        Session session = sessionService.findById(sessionId);

        if (session == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // End the session for logout
        sessionService.endSession(session);

        return ResponseEntity.ok(session.getId());
    }


    @GetMapping("/active_sessions")
    public ResponseEntity<List<Session>> getUserActiveSessions(){
        return ResponseEntity.ok(sessionService.getUserActiveSessions());
    }

}