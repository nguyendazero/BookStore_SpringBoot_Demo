package com.springboot.bookstore.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.bookstore.entity.Comment;
import com.springboot.bookstore.repository.CommentRepository;
import com.springboot.bookstore.service.CommentService;

@Service 
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        super();
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(int id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> getAllCommentByIdProduct(int idProduct) {
        return commentRepository.findAllByProductId(idProduct);
    }

}
