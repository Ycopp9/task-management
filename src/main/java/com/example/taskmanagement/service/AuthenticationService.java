package com.example.taskmanagement.service;

import com.example.taskmanagement.domain.User;
import com.example.taskmanagement.dto.AuthInfo;
import com.example.taskmanagement.util.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserService userService;

    AuthenticationService(UserService userService) {
        this.userService = userService;
    }

    public AuthInfo login(String email, String password) {
        User user = userService.getUserByEmail(email);
        if (user != null && PasswordEncoder.verify(password, user.getPassword())) {
            // 로그인 성공
            return new AuthInfo(user.getEmail(), user.getUsername());
        } else {
            // 로그인 실패
            return null;
        }
    }

    public void logout() {
        // 세션 invalidate
    }
}
