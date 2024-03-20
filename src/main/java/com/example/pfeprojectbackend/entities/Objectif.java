package com.example.pfeprojectbackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Objectif {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long objectifId;

        @NotNull
        private String Description;

        private Date DateLimite;

        @Enumerated(EnumType.STRING)
        private Etat Etat;


}
