package com.example.pfeprojectbackend.service;


import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Commentaire;
import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCommentaire implements IServiceCommentaire {

    @Autowired
    CommentaireRepository commentaireRepository;

    @Override
    public Commentaire createCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire updateCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> findAllCommentaires() {
        return commentaireRepository.findAll();
    }

    @Override
    public List<Commentaire> findCommentairebyAdminOREmploye(Administrateur administrateur, Employe employe) {
        return commentaireRepository.findCommentaireByAdministrateurOrEmployes(administrateur,employe);
    }


    @Override
    public void deleteCommentaire(Commentaire commentaire) {
        commentaireRepository.delete(commentaire);
    }
}
