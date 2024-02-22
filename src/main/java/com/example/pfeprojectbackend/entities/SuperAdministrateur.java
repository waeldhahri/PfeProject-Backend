package com.example.pfeprojectbackend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SuperAdministrateur extends User{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


}
