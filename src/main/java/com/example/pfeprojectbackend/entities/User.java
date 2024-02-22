package com.example.pfeprojectbackend.entities;




import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class User {

    @Column(nullable = false)
    private String Name;

    @NotNull(message = "Identifiant cannot be empty")
    @Column(nullable = false, unique = true)
    private String Identifiant;

    @Column(nullable = false)
    private String password;

    @Email(message = "Please enter a valid email address")
    @Column(nullable = false, unique = true)
    private String Email;





}
