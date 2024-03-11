package com.example.pfeprojectbackend.timeClockSystem;

import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.entities.SuperAdministrateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
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
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;


    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Administrateur administrateur;


    @ManyToOne
    @JoinColumn(name = "superAdmin_id", nullable = false)
    private SuperAdministrateur superAdministrateur;


    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;
    private Duration duration;
}
