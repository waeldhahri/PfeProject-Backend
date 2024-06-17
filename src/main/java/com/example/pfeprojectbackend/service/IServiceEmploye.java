package com.example.pfeprojectbackend.service;

import com.example.pfeprojectbackend.entities.Employe;

import java.util.List;

public interface IServiceEmploye {



    public Employe createEmploye(Employe employe);
    public Employe findEmployeById(Long Id);

    public Employe updateEmploye(Employe employe);

    public List<Employe> getAllEmployes();

    public void deleteEmploye(Employe employe);


    Employe findEmployeByEmail(String email);
}
