package com.chaand.practice3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaand.practice3.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
