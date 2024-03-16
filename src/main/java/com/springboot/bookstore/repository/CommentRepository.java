package com.springboot.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookstore.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

	List<Comment> findAllByProductId(int id_product);

}
