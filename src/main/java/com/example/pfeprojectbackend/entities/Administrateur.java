package com.example.pfeprojectbackend.entities;


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
public class Administrateur {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;


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

    @ManyToOne
    private Comment comment;


    @ManyToOne
    private Notification notification;


    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;


    @Enumerated(EnumType.STRING)
    private Bloc bloc;



    @ManyToMany(fetch = FetchType.EAGER)
    private List<com.example.pfeprojectbackend.newJWT.Role> roles;


}
