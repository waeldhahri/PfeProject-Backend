package com.example.pfeprojectbackend.repository;

import com.example.pfeprojectbackend.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
