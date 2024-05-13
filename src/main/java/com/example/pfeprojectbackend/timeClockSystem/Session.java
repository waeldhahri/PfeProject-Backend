package com.example.pfeprojectbackend.timeClockSystem;

import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.entities.SuperAdministrateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(columnDefinition = "session", name = "employee_id")
    private Employe employe;



    @ManyToOne
    @JoinColumn(columnDefinition = "session", name = "administrateur_id")
    private Administrateur administrateur;


    @ManyToOne
    @JoinColumn(columnDefinition = "session", name = "superadministrateur_id")
    private SuperAdministrateur superAdministrateur;

    @Column(name = "loginTime")
    private LocalDateTime loginTime;

    @Column(name = "logoutTime")
    private LocalDateTime logoutTime;

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "hours")
    private long hours   ;

    @Column(name = "minutes")
    private long minutes;
}
