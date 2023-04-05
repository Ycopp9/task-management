package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.AuthInfo;
import com.example.taskmanagement.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/auth")
public class AuthController {
    private final AuthenticationService authenticationService;
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(path = "/login")
    public @ResponseBody String login(HttpServletRequest request, @RequestParam String email, @RequestParam String password) {
        AuthInfo authInfo = authenticationService.login(email, password);
        if (authInfo != null) {
            request.getSession().setAttribute("authInfo", authInfo);
            return "Success";
        }
        return "Failed";
    }

    @GetMapping(path = "/logout")
    public @ResponseBody String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "Logout";
    }
}
