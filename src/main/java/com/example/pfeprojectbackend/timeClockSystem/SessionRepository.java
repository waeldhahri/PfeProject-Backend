package com.example.pfeprojectbackend.timeClockSystem;

import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.entities.SuperAdministrateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findByEmployeAndLogoutTimeIsNull(Employe employe);
    List<Session> findByAdministrateurAndLogoutTimeIsNull(Administrateur administrateur);
    List<Session> findBySuperAdministrateurAndLogoutTimeIsNull(SuperAdministrateur superAdministrateur);

}
