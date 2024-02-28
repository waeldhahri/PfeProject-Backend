package com.example.pfeprojectbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@AllArgsConstructor@NoArgsConstructor
@Data
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String Contenu;
    @Column(nullable = false)
    private Date Date;


    @Column(nullable = false)
    private String FeedBack;


    @ManyToMany()

    private List<Administrateur> administrateur;


    @ManyToMany()

    private List<Employe> employes;
}
