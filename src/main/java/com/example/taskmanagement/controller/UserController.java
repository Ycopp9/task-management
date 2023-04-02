package com.example.taskmanagement.controller;

import com.example.taskmanagement.domain.Role;
import com.example.taskmanagement.domain.User;
import com.example.taskmanagement.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public @ResponseBody String addNewUser(@RequestParam String username, @RequestParam String password,
                                           @RequestParam String email) {
        User n = new User(username, password, email, Role.USER);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateUser(@PathVariable Long id, @RequestParam String username, @RequestParam String password) {
        User n = userRepository.findById(id).orElseThrow();
        n.change(username, password);
        userRepository.save(n);
        return "Updated";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteUser(@PathVariable Long id) {
        User n = userRepository.findById(id).orElseThrow();
        userRepository.delete(n);
        return "Deleted";
    }

}
