package com.example.taskmanagement.service;

import com.example.taskmanagement.domain.Role;
import com.example.taskmanagement.domain.User;
import com.example.taskmanagement.dto.UserAddRequestDto;
import com.example.taskmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(UserAddRequestDto requestDto) {
        userRepository.save(requestDto.toEntity());
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void updateUser(Long id, String username, String password) {
        User user = userRepository.findById(id).orElseThrow();
        user.change(username, password);
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }
}
