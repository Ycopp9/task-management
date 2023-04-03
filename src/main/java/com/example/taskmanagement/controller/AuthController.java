package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.AuthInfo;
import com.example.taskmanagement.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
}
