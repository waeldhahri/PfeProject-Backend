package com.example.pfeprojectbackend.timeClockSystem;

import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.entities.SuperAdministrateur;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JoinColumn(name = "employee_id")
    @JsonIgnoreProperties("session")
    private Employe employe;



    @ManyToOne
    @JoinColumn(name = "administrateur_id")
    private Administrateur administrateur;



    @ManyToOne
    @JoinColumn(name = "superadministrateur_id")
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
