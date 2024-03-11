package com.example.pfeprojectbackend.timeClockSystem;

import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.service.IServiceEmploye;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("/api/sessions")
public class SessionController {

    private SessionService sessionService;

    private IServiceEmploye serviceEmploye;

    private SessionRepository sessionRepository;

    @PostMapping("/login/{employee_Id}")
    public ResponseEntity<String> login(@PathVariable Long employee_Id) {
        // Fetch user from the database
        Employe employe =  serviceEmploye.findEmployeById(employee_Id);

        if (employe == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }

        // Create a new session for login
        Session session = sessionService.createSession(employe);

        return ResponseEntity.ok("User logged in. Session ID: " + session.getId());
    }

    @PostMapping("/logout/{sessionId}")
    public ResponseEntity<String> logout(@PathVariable Long sessionId) {
        // Fetch session from the database
        Session session = sessionService.findById(sessionId);

        if (session == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session not found");
        }

        // End the session for logout
        sessionService.endSession(session);

        return ResponseEntity.ok("User logged out. Session ID: " + session.getId());
    }

}
