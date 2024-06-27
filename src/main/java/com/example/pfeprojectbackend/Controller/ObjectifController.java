package com.example.pfeprojectbackend.Controller;



import com.example.pfeprojectbackend.entities.Objectif;
import com.example.pfeprojectbackend.repository.ObjectifRepository;
import com.example.pfeprojectbackend.service.IServiceObjectif;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/objectifs")
@RequiredArgsConstructor
public class ObjectifController {



    private final IServiceObjectif iServiceObjectif;

    private final ObjectifRepository objectifRepository;




    @GetMapping("/page")
    public Page<Objectif> getAllObjectifs(Pageable pageable){
        //return objectifRepository.findAll(pageable);

        return objectifRepository.findAllByOrderByObjectifIdDesc(pageable);
    }

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
    public Objectif updateObjectif(@PathVariable Long objectifId, @Valid @RequestBody Objectif objectif){
        objectif.setObjectifId(objectifId);
        return iServiceObjectif.updateObjectif(objectif);
    }


    @DeleteMapping("/{objectifId}")
    public void deleteObjectif(@PathVariable Long objectifId){

        iServiceObjectif.deleteObjectif(iServiceObjectif.findObjectifById(objectifId));
    }


}
