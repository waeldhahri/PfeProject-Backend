package com.example.pfeprojectbackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Notification {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notifId;

    @Column(nullable = false)
    @NotNull
    private String message;

    @Column(nullable = false)
    @NotNull
    private Date dateofNotif;


    @ManyToOne
    @JoinColumn(name ="employe_id", nullable = false , insertable = false , updatable = false)
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "administrateur_id", nullable = false , insertable = false ,
    updatable = false)
    private Administrateur administrateur;


}
