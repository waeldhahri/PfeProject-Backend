package com.example.pfeprojectbackend.jwt;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET_KEY ="secret";

    public String generateToken(String name){
        Date now = new Date();
        Date expirationDate = new Date(now.getTime()+86400000);
        return Jwts.builder()
                .setSubject(name)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

    }


    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }


}
