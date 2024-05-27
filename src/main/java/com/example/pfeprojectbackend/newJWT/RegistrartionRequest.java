package com.example.pfeprojectbackend.newJWT;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Getter
@Setter
@Builder
public class RegistrartionRequest {



    @NotEmpty(message = "username cannot be empty")
    @NotBlank
    private String username;

    @NotNull(message = "Identifiant cannot be empty")
    @NotEmpty
    private String identifiant;

    private String password;

    @Email(message = "Please enter a valid email address")
    private String email;

    @NotNull
    @NotEmpty(message = "role cannot be empty")
    private String role;

}
