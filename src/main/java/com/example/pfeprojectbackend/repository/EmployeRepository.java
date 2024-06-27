package com.example.pfeprojectbackend.repository;

import com.example.pfeprojectbackend.entities.Employe;
import com.example.pfeprojectbackend.newJWT.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {


    Optional<Employe> findByEmail(String Email);

    List<Employe> findByRoles(Optional<Role> roles);


}
