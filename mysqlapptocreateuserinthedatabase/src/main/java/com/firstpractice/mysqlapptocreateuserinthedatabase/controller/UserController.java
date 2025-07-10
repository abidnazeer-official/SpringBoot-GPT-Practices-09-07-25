package com.firstpractice.mysqlapptocreateuserinthedatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.firstpractice.mysqlapptocreateuserinthedatabase.model.User;
import com.firstpractice.mysqlapptocreateuserinthedatabase.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }
}
