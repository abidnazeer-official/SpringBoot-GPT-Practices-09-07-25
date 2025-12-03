package com.examplep2.demop2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplep2.demop2.model.User;
import com.examplep2.demop2.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository UserRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return UserRepository.findAll();
        // Logic to retrieve all users
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return UserRepository.save(user);
    }

    @GetMapping("/{id}")
    public User save(@PathVariable Long id){
        return UserRepository.findById(id).orElse(null);
    }

    public User updateUser(@PathVariable Long id, @RequestBody User updatUser){

        return userRepository.findById(id).map(user -> {
            user.setName(getName());
            user.setEmail(getEmail());
            return userRepository.save(user);
        }).orElse(null);
    }
}
