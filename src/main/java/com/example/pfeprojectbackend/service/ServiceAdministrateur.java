package com.example.pfeprojectbackend.service;

import com.example.pfeprojectbackend.entities.Administrateur;
import com.example.pfeprojectbackend.repository.AdministrateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ServiceAdministrateur implements IServiceAdmin{





    private final AdministrateurRepository administrateurRepository;

    @Override
    public Administrateur createAdmin(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    @Override
    public Administrateur findAdministrateurById(Long Id) {
        return administrateurRepository.findById(Id).get();
    }

    @Override
    public Administrateur findAdministrateurByEmail(String Email) {
        return administrateurRepository.findByEmail(Email).get();
    }



    @Override
    public Administrateur updateAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    @Override
    public List<Administrateur> getAllAdministrateur() {
        return administrateurRepository.findAll();
    }

    @Override
    public void deleteAdministrateur(Administrateur administrateur) {
        administrateurRepository.delete(administrateur);
    }
}
