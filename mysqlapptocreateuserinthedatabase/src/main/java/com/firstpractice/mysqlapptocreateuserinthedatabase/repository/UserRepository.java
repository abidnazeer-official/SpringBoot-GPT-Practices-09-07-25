package com.firstpractice.mysqlapptocreateuserinthedatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstpractice.mysqlapptocreateuserinthedatabase.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
