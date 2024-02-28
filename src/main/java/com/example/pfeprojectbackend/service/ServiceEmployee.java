package com.example.pfeprojectbackend.service;

import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ServiceEmployee implements IServiceEmploye{


    private final EmployeRepository employeRepository;


    @Override
    public Employe createEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe findEmployeById(Long Id) {
        return employeRepository.findById(Id).get();
    }

    @Override
    public Employe updateEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public void deleteEmploye(Employe employe) {
        employeRepository.delete(employe);

    }
}
