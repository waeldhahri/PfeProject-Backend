package com.example.pfeprojectbackend.timeClockSystem;


import com.example.pfeprojectbackend.entities.Employe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
public class SessionService {



    private SessionRepository sessionRepository;


    public Session createSession(Employe employe) {
        Session session = new Session();
        session.setEmploye(employe);
        session.setLoginTime(LocalDateTime.now());
        return sessionRepository.save(session);
    }

    public void endSession(Session session) {
        session.setLogoutTime(LocalDateTime.now());

        // Calculate the duration and update the session
        Duration duration = Duration.between(session.getLoginTime(), session.getLogoutTime());


        sessionRepository.save(session);
    }

    public List<Session> getUserActiveSessions(Employe employe) {
        return sessionRepository.findByEmployeAndLogoutTimeIsNull(employe);
    }


    public Session findById(Long sessionId) {
        return sessionRepository.findById(sessionId).orElse(null);
    }
}
