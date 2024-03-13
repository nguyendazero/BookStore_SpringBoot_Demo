package com.springboot.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookstore.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
