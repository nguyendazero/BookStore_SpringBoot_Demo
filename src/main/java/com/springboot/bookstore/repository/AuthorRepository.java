package com.springboot.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookstore.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
