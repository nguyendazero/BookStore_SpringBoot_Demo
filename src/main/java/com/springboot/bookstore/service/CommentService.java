package com.springboot.bookstore.service;

import java.util.List;

import com.springboot.bookstore.entity.Comment;

public interface CommentService {

	List<Comment> getAllCommentByIdProduct(int id_product);
	
	Comment saveComment(Comment Comment);
	
	Comment getCommentById(int id);
	
	Comment updateComment(Comment Comment);
	
	void deleteComment(int id);
	
}
