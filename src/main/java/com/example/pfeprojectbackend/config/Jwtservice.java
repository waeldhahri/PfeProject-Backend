package com.example.pfeprojectbackend.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
/*
@Service
public class Jwtservice {

    @Autowired
    private static  final String SECRET_KEY = "eZqjuzqqLo4tElCuVjVkqPLp1gaaHGRc8x5xHBljo4kK4dhQzChJX67pBmYRM/VScICh01PhV9l5DFq02MfMWsOsvUuAKSJu7kxUO++Meqe9+9FoGwxtsnkDH0R4l6t7qHESWAJ8iEO7ptNLDVXWBVYSTvzHCOtacQFzubJuU/jBfcWIg+t0eOLioANRzebqfZVpegbkr/xToWjs5olLMXV8kMv6vURObOvOs7pGMjdl7C44lMQeh9gYXoVdT550NxXFTDJfW5mZ/XF+eWBR1ZwDgzGw4H2oq6wSf3qOel07H5COWTJ3i07WItOeM8t6DKtzsNe8tayG2qk9J9vqvxs3CCEaM0bM9cUw4sGivfc=";

    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }
    public <T> T extractClaim(String token , Function<Claims , T> claimsTResolver){
        final Claims claims = extractAllClaims(token);
        return claimsTResolver.apply(claims);
    }


    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }



    private String generateToken(
            Map<String,Object> extraClaims, UserDetails userDetails
            ){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    public boolean isTokenValid(String token , UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);

    }
}
*/