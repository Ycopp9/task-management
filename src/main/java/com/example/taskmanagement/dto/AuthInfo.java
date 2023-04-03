package com.example.taskmanagement.dto;

public class AuthInfo {
    private String email;
    private String username;
    public AuthInfo(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
