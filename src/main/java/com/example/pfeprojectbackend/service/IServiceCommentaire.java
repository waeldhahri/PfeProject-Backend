package com.example.pfeprojectbackend.service;

import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Commentaire;
import com.example.pfeprojectbackend.entities.Employe;

import java.util.List;

public interface IServiceCommentaire {

    public Commentaire createCommentaire(Commentaire commentaire);
    public Commentaire updateCommentaire(Commentaire commentaire);
    public List<Commentaire> findAllCommentaires();

    public List<Commentaire> findCommentairebyAdminOREmploye(Administrateur administrateur, Employe employe);
    public void deleteCommentaire(Commentaire commentaire);



}
