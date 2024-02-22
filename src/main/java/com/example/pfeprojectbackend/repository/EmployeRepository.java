package com.example.pfeprojectbackend.repository;

import com.example.pfeprojectbackend.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
