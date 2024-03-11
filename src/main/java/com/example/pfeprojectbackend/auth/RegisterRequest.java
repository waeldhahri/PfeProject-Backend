package com.example.pfeprojectbackend.auth;

import com.example.pfeprojectbackend.entities.Comment;
import com.example.pfeprojectbackend.entities.Notification;
import com.example.pfeprojectbackend.entities.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empolyeeId;
    private String username;
    private String email;
    private String  password;
    private String identifiant;

  //  private Comment comment;
   // private Notification notification;
    @Enumerated(EnumType.STRING)
    private Role role;





}
