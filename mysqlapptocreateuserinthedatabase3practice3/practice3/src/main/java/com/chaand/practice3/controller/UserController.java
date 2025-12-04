package com.chaand.practice3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaand.practice3.model.User;
import com.chaand.practice3.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public User updatUser(@PathVariable Long id, @RequestBody User updateUser){
        System.out.println("Received: " + updateUser.getName() + ", " + updateUser.getEmail());
        return userRepository.findById(id).map(user -> {
            user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
            return userRepository.save(user);
        }).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}
