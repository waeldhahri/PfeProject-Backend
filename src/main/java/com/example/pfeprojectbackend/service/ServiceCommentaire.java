package com.example.pfeprojectbackend.service;


import com.example.pfeprojectbackend.entities.Comment;
import com.example.pfeprojectbackend.repository.CommentaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceCommentaire implements IServiceCommentaire {


    private final CommentaireRepository commentaireRepository;

    @Override
    public Comment createCommentaire(Comment comment) {
        return commentaireRepository.save(comment);
    }

    @Override
    public Comment updateCommentaire(Comment comment) {
        return commentaireRepository.save(comment);
    }

    @Override
    public List<Comment> findAllCommentaires() {
        return commentaireRepository.findAll();
    }

    @Override
    public List<Comment> findCommentairebyAdminOREmploye(Long adminId, Long employeId) {

        return commentaireRepository.findCommentaireByAdministrateur_adminIdOrEmployes_employeeId(adminId,employeId);
    }


    @Override
    public void deleteCommentaire(Comment comment) {
        commentaireRepository.delete(comment);
    }
}
