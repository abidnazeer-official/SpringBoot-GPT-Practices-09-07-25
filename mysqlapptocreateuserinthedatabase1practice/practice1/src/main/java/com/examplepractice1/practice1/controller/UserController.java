package com.examplepractice1.practice1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplepractice1.practice1.model.User;
import com.examplepractice1.practice1.repository.UserRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/abid/api")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

   @GetMapping("/users")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }
    @PutMapping("{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updateUser){
        System.out.println("Received: " + updateUser.getName() + ", " + updateUser.getEmail());

        return userRepository.findById(id).map(user -> {
            user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
            return userRepository.save(user);
        }).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}
