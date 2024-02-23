package com.example.pfeprojectbackend.service;


import com.example.pfeprojectbackend.entities.Objectif;
import com.example.pfeprojectbackend.repository.ObjectifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceObjectif implements IServiceObjectif {


    @Autowired
    ObjectifRepository objectifRepository;


    @Override
    public Object createObjectif(Objectif objectif) {
        return objectifRepository.save(objectif);
    }
}
