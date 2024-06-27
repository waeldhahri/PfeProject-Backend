package com.example.pfeprojectbackend.service;

import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.newJWT.Role;
import com.example.pfeprojectbackend.newJWT.RoleRepository;
import com.example.pfeprojectbackend.repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ServiceEmployee implements IServiceEmploye{


    private final EmployeRepository employeRepository;
    private final RoleRepository roleRepository;


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
        return employeRepository.findAll().stream()
                .sorted(Comparator.comparingLong(Employe::getEmployeeId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmploye(Employe employe) {
        employeRepository.delete(employe);

    }

    @Override
    public Employe findEmployeByEmail(String email) {
        return employeRepository.findByEmail(email).isPresent() ? employeRepository.findByEmail(email).get() : null ;
    }

   @Override
    public List<Employe> findEmployeByRole(String roleName) {
        Optional<Role> role = roleRepository.findByName(roleName);
        if (role.isPresent()) {
            return employeRepository.findByRoles(role)
                    .stream()
                    .sorted(Comparator.comparingLong(Employe::getEmployeeId).reversed())
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Role not found");
        }
    }
}
