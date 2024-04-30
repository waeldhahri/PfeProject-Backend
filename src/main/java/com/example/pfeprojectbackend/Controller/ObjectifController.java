package com.example.pfeprojectbackend.Controller;



import com.example.pfeprojectbackend.entities.Objectif;
import com.example.pfeprojectbackend.service.IServiceObjectif;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/objectifs")
@RequiredArgsConstructor
public class ObjectifController {



    private final IServiceObjectif iServiceObjectif;



    @GetMapping("")
    public List<Objectif> getAllObjectif(){

        return iServiceObjectif.getAllObjectifs();

    }

    @GetMapping("/datelimite")
    public List<Objectif> getAlldateLimites(){

        return iServiceObjectif.getAllObjectifs();
    }



    @PostMapping("")
    public Objectif createEmploye(@Valid @RequestBody Objectif objectif){

        return iServiceObjectif.createObjectif(objectif);
    }

    @GetMapping("/{objectifId}")
    public Objectif findObjectifById(@PathVariable Long objectifId){

        return iServiceObjectif.findObjectifById(objectifId);
    }

    @PutMapping("/{objectifId}")
    public Objectif updateObjectif(@Valid @RequestBody Objectif objectif){
        return iServiceObjectif.updateObjectif(objectif);
    }


    @DeleteMapping("/{objectifId}")
    public void deleteObjectif(@PathVariable Long objectifId){
        iServiceObjectif.deleteObjectif(iServiceObjectif.findObjectifById(objectifId));
    }


}
