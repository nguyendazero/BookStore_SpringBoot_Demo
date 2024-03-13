package com.springboot.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookstore.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
