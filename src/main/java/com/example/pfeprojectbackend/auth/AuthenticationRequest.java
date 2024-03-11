package com.example.pfeprojectbackend.auth;


import com.example.pfeprojectbackend.entities.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {


    private String email;
    private String password;
    private String identifiant;



    @Enumerated(EnumType.STRING)
    private Role role;




}
