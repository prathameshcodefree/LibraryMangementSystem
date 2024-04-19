package com.tp.lms.model;

import java.security.SecureRandom;
import java.util.Base64;

public class TokenUtils {

    private static final int TOKEN_LENGTH = 32;

    public static String generateRandomToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[TOKEN_LENGTH];
        secureRandom.nextBytes(tokenBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }
}

