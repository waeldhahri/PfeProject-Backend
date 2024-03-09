package com.example.pfeprojectbackend.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

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
    private String name;

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


    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;




}
