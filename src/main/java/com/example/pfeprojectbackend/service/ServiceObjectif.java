package com.example.pfeprojectbackend.service;


import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.entities.Objectif;
import com.example.pfeprojectbackend.repository.ObjectifRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServiceObjectif implements IServiceObjectif {


    @Autowired
    private  SimpMessagingTemplate messagingTemplate;
    @Autowired
    private  ObjectifRepository objectifRepository;


    @Override
    public Objectif createObjectif(Objectif objectif) {
        return objectifRepository.save(objectif);
    }

    @Override
    public Objectif findObjectifById(Long Id) {
        return objectifRepository.findById(Id).get();
    }

    @Override
    public Objectif updateObjectif(Objectif objectif) {
        return null;
    }

    @Override
    public List<Objectif> getAllObjectifs() {
        return null;
    }

    @Override
    public void deleteObjectif(Objectif objectif) {

    }

    @Override
    public void progressObjectif(Date datelimite) {
       messagingTemplate.getMessageChannel();
    }


}
