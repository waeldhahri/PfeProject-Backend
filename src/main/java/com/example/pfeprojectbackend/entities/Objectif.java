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
public class Objectif {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long objectifId;



        private String objectifTitle;

        private String objectifType;

        private Date objectifStart;

        private String assigned;

        @NotNull
        private String description;

        private Date dateLimite;

        /*
        @Enumerated(EnumType.STRING)
        private Etat etat;

*/
        @ManyToMany
        private List<Employe> employe;

        @ManyToMany
        private List<Administrateur> administrateurs;

        @ManyToMany
        private List<SuperAdministrateur> superAdministrateurs;



}
