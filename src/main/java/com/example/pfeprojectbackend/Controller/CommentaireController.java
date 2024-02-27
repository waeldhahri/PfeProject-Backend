package com.example.pfeprojectbackend.Controller;


import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Commentaire;
import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.service.IServiceCommentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaire/")
@CrossOrigin
public class CommentaireController {


    @Autowired
    IServiceCommentaire iServiceCommentaire;



    @GetMapping("getall")
    public List<Commentaire> getAllComment(){
        return iServiceCommentaire.findAllCommentaires();
    }

    @PostMapping("addCommentaire")
    public Commentaire createCommentaire(Commentaire commentaire){
        return iServiceCommentaire.createCommentaire(commentaire);
    }


    @GetMapping("find/{administrateur}/{employe}")
    public List<Commentaire> findCommentaireBy(@PathVariable Administrateur administrateur,@PathVariable Employe employe){

        return iServiceCommentaire.findCommentairebyAdminOREmploye(administrateur, employe);
    }

}
