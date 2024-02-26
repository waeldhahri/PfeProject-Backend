package com.example.pfeprojectbackend.Controller;



import com.example.pfeprojectbackend.entities.Objectif;
import com.example.pfeprojectbackend.service.IServiceObjectif;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/objectif/")
public class ObjectifController {


    @Autowired
    IServiceObjectif iServiceObjectif;



    @GetMapping("getall")
    public List<Objectif> getAllObjectif(){

        return iServiceObjectif.getAllObjectifs();

    }


    @PostMapping("addEmploye")
    public Objectif createEmploye(@Valid @RequestBody Objectif objectif){

        return iServiceObjectif.createObjectif(objectif);
    }

    @GetMapping("getobjectif/{id}")
    public Objectif findObjectifById(@PathVariable Long id){

        return iServiceObjectif.findObjectifById(id);
    }

    @PutMapping("updateobjectif")
    public Objectif updateObjectif(@Valid @RequestBody Objectif objectif){
        return iServiceObjectif.updateObjectif(objectif);
    }


    @DeleteMapping("deleteObjectif/{id}")
    public void deleteObjectif(@PathVariable Long id){
        iServiceObjectif.deleteObjectif(iServiceObjectif.findObjectifById(id));
    }


}
