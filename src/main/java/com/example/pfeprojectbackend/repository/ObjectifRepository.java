package com.example.pfeprojectbackend.repository;

import com.example.pfeprojectbackend.entities.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectifRepository extends JpaRepository<Objectif , Long> {



}
