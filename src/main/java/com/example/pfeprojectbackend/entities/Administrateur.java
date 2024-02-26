package com.example.pfeprojectbackend.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Administrateur {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String Name;

    @NotNull(message = "Identifiant cannot be empty")
    @Column(nullable = false, unique = true)
    private String Identifiant;

    @Column(nullable = false)
    private String password;

    @Email(message = "Please enter a valid email address")
    @Column(nullable = false, unique = true)
    @NaturalId(mutable = true)
    private String Email;


    @Enumerated(EnumType.STRING)
    private Role role;


    @ManyToOne
    private Commentaire commentaire;


    @ManyToOne
    private Notification notification;

}
