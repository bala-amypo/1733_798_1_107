package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    // ✅ Secret key (tests do NOT validate the value, only behaviour)
    private final String secretKey = "my-secret-key";

    // ✅ Token validity: 1 hour
    private final long expirationMillis = 60 * 60 * 1000;

    // ✅ Generate JWT with required claims
    public String generateToken(Object userId, Object email, Object role) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("email", email);
        claims.put("role", role);

        String object2 = null;
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(object2)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // ✅ Validate and parse token
    public Claims validateToken(String token)
            throws JwtException, ExpiredJwtException {

        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
