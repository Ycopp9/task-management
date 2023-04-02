package com.example.taskmanagement.repository;

import com.example.taskmanagement.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
