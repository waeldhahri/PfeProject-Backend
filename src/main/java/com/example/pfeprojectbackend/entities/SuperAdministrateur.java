package com.example.pfeprojectbackend.entities;


import com.example.pfeprojectbackend.timeClockSystem.Session;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SuperAdministrateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long superAdminId;


    @Column(nullable = false)
    private String username;

    @NotNull(message = "Identifiant cannot be empty")
    @Column(nullable = false, unique = true)
    @NaturalId(mutable = true)
    private String identifiant;

    @Column(nullable = false)
    private String password;

    @Email(message = "Please enter a valid email address")
    @Column(nullable = false, unique = true)
    @NaturalId(mutable = true)
    private String email;




    @ManyToMany(fetch = FetchType.EAGER)
    private List<com.example.pfeprojectbackend.newJWT.Role> roles;



    @OneToMany(mappedBy = "superAdministrateur")
    private List<Session> session;


    @ManyToMany
    private List<Objectif> objectifs;

}
