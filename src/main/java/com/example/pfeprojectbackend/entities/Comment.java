package com.example.pfeprojectbackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    @NotNull
    private String message;

    @Column(nullable = false)
    private Date dateOfComment;


    @Column(nullable = false)
    private String feedBack;


    @ManyToMany
    private List<Administrateur> administrateur;


    @ManyToMany
    private List<Employe> employes;
}
