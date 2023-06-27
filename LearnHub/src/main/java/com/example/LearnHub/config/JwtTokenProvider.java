package com.example.LearnHub.config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;



@Component
public class JwtTokenProvider {

    private final String secretKey;
    private final long expirationMs;

    public JwtTokenProvider(@Value("${jwt.secret}") String secretKey, @Value("${jwt.expiration}") long expirationMs) {
        this.secretKey = secretKey;
        this.expirationMs = expirationMs;
    }

    public String generateToken(UserDetails userDetails) {
        // Реализация метода
        return null;
    }

    public boolean validateToken(String token) {
        // Реализация метода
        return false;
    }

    public String getUsernameFromToken(String token) {
        // Реализация метода
        return null;
    }
}

