package com.example.pfeprojectbackend.repository;

import com.example.pfeprojectbackend.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Comment, Long> {








    List<Comment> findCommentaireByAdministrateur_adminIdOrEmployes_employeeId(Long adminId , Long employeeId);
}
