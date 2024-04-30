package com.example.pfeprojectbackend.config;
/*

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
*/
/*  @Autowired
    private final JwtAuthenticationFilter jwtAuthFilter;
*//*
        @Autowired
   // private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{


        return http.csrf((csrf)->csrf.disable())
                .authorizeHttpRequests
                        ((ar)->ar.requestMatchers("/api/v1/auth/**","/employees/**","/api/sessions/**","/**")
                        .permitAll().anyRequest().authenticated())
                //.sessionManagement
                       // ((sm)->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               // .authenticationProvider(authenticationProvider)
               // .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)


                .build();





    }
}
*/