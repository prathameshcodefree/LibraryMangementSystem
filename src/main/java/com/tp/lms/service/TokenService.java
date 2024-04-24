package com.tp.lms.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.lms.model.Student;
import com.tp.lms.model.Token;
import com.tp.lms.repository.TokenRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    // Token expiration time in minutes
    private static final long EXPIRATION_TIME_MINUTES = 60;

    // Method to generate and store token
    public String generateAndStoreToken(Student student) {
        String token = UUID.randomUUID().toString();
        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(EXPIRATION_TIME_MINUTES);

        // Create token entity
        Token tokenEntity = new Token();
        tokenEntity.setToken(token);
        tokenEntity.setStudent(student);
        tokenEntity.setExpiryTime(expiryTime);
        tokenEntity.setValid(true);
        tokenEntity.setLogoutTime(null);

        // Save token entity
        tokenRepository.save(tokenEntity);

        return token;
    }

    // Method to validate token
    public boolean isTokenValid(String token) {
        Token tokenEntity = tokenRepository.findByToken(token);
        return tokenEntity != null && tokenEntity.isValid() && tokenEntity.getExpiryTime().isAfter(LocalDateTime.now());
    }

    // Method to invalidate token (logout)
    public void invalidateToken(String token) {
        Token tokenEntity = tokenRepository.findByToken(token);
        if (tokenEntity != null) {
            tokenEntity.setValid(false);
            tokenEntity.setLogoutTime(LocalDateTime.now());
            tokenRepository.save(tokenEntity);
        }
    }
}
