package com.example.taskmanagement.dto;

import com.example.taskmanagement.domain.Role;

public class AuthInfo {
    private String email;
    private String username;
    private Role role;
    public AuthInfo(String email, String username, Role role) {
        this.email = email;
        this.username = username;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
    public Role getRole() {
        return role;
    }
}
