package com.example.pfeprojectbackend.Controller;


import com.example.pfeprojectbackend.entities.Commentaire;
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
    public List<Commentaire> getAllComment(){
        return iServiceCommentaire.findAllCommentaires();
    }

    @PostMapping("")
    public Commentaire createCommentaire(Commentaire commentaire){
        return iServiceCommentaire.createCommentaire(commentaire);
    }


    @GetMapping("find/{adminId}/{employeeId}")
    public List<Commentaire> findCommentaireBy(@PathVariable String adminId,@PathVariable String employeeId){

        return iServiceCommentaire.findCommentairebyAdminOREmploye(adminId, employeeId);
    }

}
