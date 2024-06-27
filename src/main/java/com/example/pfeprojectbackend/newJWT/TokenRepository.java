package com.example.pfeprojectbackend.newJWT;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {


    Optional<Token> findByToken(String token);


    @Modifying
    @Query("UPDATE Token t SET t.employe.employeeId = null WHERE t.employe.employeeId = :employeeId")
    void clearEmployeeReferences(@Param("employeeId") Long employeeId);
}
