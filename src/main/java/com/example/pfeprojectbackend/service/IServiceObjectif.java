package com.example.pfeprojectbackend.service;

import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Objectif;

import java.util.Date;
import java.util.List;

public interface IServiceObjectif {

    public Objectif createObjectif(Objectif objectif);

    public Objectif findObjectifById(Long Id); //find Administrateur by ID



    public Objectif updateObjectif(Objectif objectif);

    public List<Objectif> getAllObjectifs();

    public void deleteObjectif(Objectif objectif);



    public void progressObjectif(Date datelimite);

}
