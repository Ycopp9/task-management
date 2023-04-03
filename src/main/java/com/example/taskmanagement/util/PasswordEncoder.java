package com.example.taskmanagement.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public static String encode(String password) {
        return encoder.encode(password);
    }

    public static boolean verify(String password, String hashedPassword) {
        return encoder.matches(password, hashedPassword);
    }
}
