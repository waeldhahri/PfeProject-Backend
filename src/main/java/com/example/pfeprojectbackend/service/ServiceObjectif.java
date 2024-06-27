package com.example.pfeprojectbackend.service;


import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.entities.Objectif;
import com.example.pfeprojectbackend.repository.ObjectifRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        return objectifRepository.save(objectif);
    }

    @Override
    public List<Objectif> getAllObjectifs() {
        return objectifRepository.findAll()
                .stream()
                .sorted(Comparator.comparingLong(Objectif::getObjectifId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteObjectif(Objectif objectif) {

        objectifRepository.delete(objectif);

    }

    @Override
    public void progressObjectif(Date datelimite) {
       messagingTemplate.getMessageChannel();
    }


}
