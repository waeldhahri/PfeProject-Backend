package com.example.pfeprojectbackend.entities;


import com.example.pfeprojectbackend.newJWT.Role;
import com.example.pfeprojectbackend.timeClockSystem.Session;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "_employe")
@EntityListeners(AuditingEntityListener.class)
public class Employe implements UserDetails , Principal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;


    @Column(nullable = false)
    private String username;

    @NotNull(message = "Identifiant cannot be empty")
    @Column(nullable = false, unique = true)
    @NotEmpty
    @NaturalId(mutable = true)
    private String identifiant;

    @Column(nullable = false)
    private String password;

    @Email(message = "Please enter a valid email address")
    @Column(nullable = false, unique = true)
    @NaturalId(mutable = true)
    private String email;


    private boolean accountLocked;
    private boolean enabled;


    @OneToMany(mappedBy = "employe")
    private List<Session> session;


    @ManyToOne
    private Comment comments;

    @CreatedDate
    @Column(nullable = false,updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    @ManyToOne
    private Notification notification;

    //@Enumerated(EnumType.STRING)
   // private Role role;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @Enumerated(EnumType.STRING)
    private Bloc bloc;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(r-> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getName() {
        return username;
    }
}