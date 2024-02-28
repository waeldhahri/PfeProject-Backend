package com.example.pfeprojectbackend.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employe {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;


    @Column(nullable = false)
    private String Name;

    @NotNull(message = "Identifiant cannot be empty")
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String Identifiant;

    @Column(nullable = false)
    private String password;

    @Email(message = "Please enter a valid email address")
    @Column(nullable = false, unique = true)
    private String Email;


    @ManyToOne
    private Comment commentaires;


    @ManyToOne
    private Notification notification;

}