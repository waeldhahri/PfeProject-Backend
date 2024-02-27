package com.example.pfeprojectbackend.repository;

import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Commentaire;
import com.example.pfeprojectbackend.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentaireRepository extends JpaRepository<Commentaire , Long> {



    List<Commentaire> findCommentaireByAdministrateurOrEmployes(Administrateur administrateur, Employe employe);
}
