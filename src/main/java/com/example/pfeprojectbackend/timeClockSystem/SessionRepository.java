package com.example.pfeprojectbackend.timeClockSystem;

import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.entities.SuperAdministrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findByEmployeAndLogoutTimeIsNull(Employe employe);
    List<Session> findByAdministrateurAndLogoutTimeIsNull(Administrateur administrateur);
    List<Session> findBySuperAdministrateurAndLogoutTimeIsNull(SuperAdministrateur superAdministrateur);

    List<Session> findByLogoutTimeIsNullAndLoginTimeIsNotNull();

    @Modifying
    @Query("UPDATE Session t SET t.employe.employeeId = null WHERE t.employe.employeeId = :employeeId")
    void clearEmployeeReferences(@Param("employeeId") Long employeeId);

}
