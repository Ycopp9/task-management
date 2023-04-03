package com.example.taskmanagement.dto;

import com.example.taskmanagement.domain.Role;
import com.example.taskmanagement.domain.User;

public class UserAddRequestDto {
    private String username;
    private String password;
    private String email;
    private Role role;

    public UserAddRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = Role.USER;
    }

    public User toEntity() {
        return new User(username, password, email, role);
    }
}
