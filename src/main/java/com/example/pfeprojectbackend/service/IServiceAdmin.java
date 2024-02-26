package com.example.pfeprojectbackend.service;

import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Employe;

import java.util.List;

public interface IServiceAdmin {

    public Administrateur createAdmin(Administrateur administrateur);//create a new administrateur
    public Administrateur findAdministrateurById(Long Id); //find Administrateur by ID


    public Administrateur findAdministrateurByEmail(String Email);

    public Administrateur updateAdministrateur(Administrateur administrateur);

    public List<Administrateur> getAllAdministrateur();

    public void deleteAdministrateur(Administrateur administrateur);
}
