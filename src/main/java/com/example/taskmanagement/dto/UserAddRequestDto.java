package com.example.taskmanagement.dto;

import com.example.taskmanagement.domain.Role;
import com.example.taskmanagement.domain.User;
import com.example.taskmanagement.util.PasswordEncoder;

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
        String hashedPassword = PasswordEncoder.encode(password);
        return new User(username, hashedPassword, email, role);
    }
}
