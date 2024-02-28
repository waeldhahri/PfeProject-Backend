package com.example.pfeprojectbackend.Controller;


import com.example.pfeprojectbackend.entities.Comment;
import com.example.pfeprojectbackend.service.IServiceCommentaire;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin
@RequiredArgsConstructor
public class CommentController {



    private final IServiceCommentaire iServiceCommentaire;



    @GetMapping("")
    public List<Comment> getAllComment(){
        return iServiceCommentaire.findAllCommentaires();
    }

    @PostMapping("")
    public Comment createCommentaire(Comment comment){
        return iServiceCommentaire.createCommentaire(comment);
    }


    @GetMapping("/find/{adminId}/{employeeId}")
    public List<Comment> findCommentaireByAdminAndEmployee(@PathVariable Long adminId, @PathVariable Long employeeId){

        return iServiceCommentaire.findCommentairebyAdminOREmploye(adminId, employeeId) ;
    }



}
