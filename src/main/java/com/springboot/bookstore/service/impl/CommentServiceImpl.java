package com.springboot.bookstore.service.impl;

import java.util.List;

import com.springboot.bookstore.entity.Comment;
import com.springboot.bookstore.repository.CommentRepository;
import com.springboot.bookstore.service.CommentService;

public class CommentServiceImpl implements CommentService{

	private CommentRepository commentRepository;

	public CommentServiceImpl(CommentRepository commentRepository) {
		super();
		this.commentRepository = commentRepository;
	}


	@Override
	public Comment saveComment(Comment Comment) {
		return commentRepository.save(Comment);
	}

	@Override
	public Comment getCommentById(int id) {
		return commentRepository.findById(id).get();
	}

	@Override
	public Comment updateComment(Comment Comment) {
		return commentRepository.save(Comment);
	}

	@Override
	public void deleteComment(int id) {
		commentRepository.deleteById(id);
		
	}

	@Override
	public List<Comment> getAllCommentByIdProduct(int id_product) {
        return commentRepository.findAllByProductId(id_product);
    }

}
