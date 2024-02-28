package com.example.pfeprojectbackend.service;

import com.example.pfeprojectbackend.entities.Comment;

import java.util.List;

public interface IServiceCommentaire {

    public Comment createCommentaire(Comment comment);
    public Comment updateCommentaire(Comment comment);
    public List<Comment> findAllCommentaires();

    public List<Comment> findCommentairebyAdminOREmploye(Long adminId, Long employeId);
    public void deleteCommentaire(Comment comment);



}
