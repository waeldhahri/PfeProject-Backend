package com.example.pfeprojectbackend.repository;

import com.example.pfeprojectbackend.entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur,Long> {



    Optional<Administrateur> findByEmail(String Email);
}
