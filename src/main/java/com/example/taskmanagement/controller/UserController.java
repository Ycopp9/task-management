package com.example.taskmanagement.controller;

import com.example.taskmanagement.domain.User;
import com.example.taskmanagement.dto.UserAddRequestDto;
import com.example.taskmanagement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public @ResponseBody String addNewUser(@RequestBody UserAddRequestDto requestDto) {
        userService.addUser(requestDto);
        return "Saved";
    }

    @GetMapping
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateUser(@PathVariable Long id, @RequestParam String username, @RequestParam String password) {
        userService.updateUser(id, username, password);
        return "Updated";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "Deleted";
    }

}
