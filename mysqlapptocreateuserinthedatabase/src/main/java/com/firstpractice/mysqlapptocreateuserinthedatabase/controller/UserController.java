package com.firstpractice.mysqlapptocreateuserinthedatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.firstpractice.mysqlapptocreateuserinthedatabase.model.User;
import com.firstpractice.mysqlapptocreateuserinthedatabase.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
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

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        System.out.println("📥 Received: " + updatedUser.getName() + ", " + updatedUser.getEmail());
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user);
        }).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
