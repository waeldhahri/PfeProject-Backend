package com.example.pfeprojectbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "administrateur_id", nullable = false , insertable = false , updatable = false)
    private Administrateur administrateur;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "employe_id", nullable = false , insertable = false , updatable = false)
    private Employe employes;
}
