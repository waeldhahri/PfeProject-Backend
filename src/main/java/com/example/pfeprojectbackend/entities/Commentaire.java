package com.example.pfeprojectbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@AllArgsConstructor@NoArgsConstructor
@Data
public class Commentaire {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Contenu;
    @Column(nullable = false)
    private Date Date;


    @Column(nullable = false)
    private String FeedBack;
}
