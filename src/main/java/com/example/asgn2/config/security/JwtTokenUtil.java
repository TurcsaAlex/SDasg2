package com.example.asgn2.config.security;


import com.example.asgn2.model.User;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateAccessToken(User user) {
        return generateAccessToken(user.getEmail());
    }

    public String generateAccessToken(AuthUser user) {
        return generateAccessToken(user.getUsername());
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(jwtSecret)
                            .parseClaimsJws(token)
                            .getBody();
        return claims.getSubject();
    }

    public Date getExpirationDate(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(jwtSecret)
                            .parseClaimsJws(token)
                            .getBody();
        return claims.getExpiration();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            System.out.println("Validate error");
        }
        return false;
    }

    private String generateAccessToken(String username) {
        return Jwts.builder()
                   .setSubject(username)
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis() + 60L * 24 * 60 * 60 * 1000)) // 60 days
                   .signWith(SignatureAlgorithm.HS512, jwtSecret)
                   .compact();
    }
}
