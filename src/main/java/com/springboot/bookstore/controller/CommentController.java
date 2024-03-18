package com.springboot.bookstore.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.bookstore.entity.Comment;
import com.springboot.bookstore.entity.Product;
import com.springboot.bookstore.entity.User;
import com.springboot.bookstore.service.CommentService;
import com.springboot.bookstore.service.ProductService;

import jakarta.servlet.http.HttpSession;
@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	@Autowired
    private HttpSession session;
	@Autowired
	private ProductService productService;

	@PostMapping("/add-comment/{id}")
	public String addComment(@PathVariable int id, @RequestParam("comment") String comment, Model model) {
		User userLogin = (User) session.getAttribute("userLogin");
		LocalDate currentDate = LocalDate.now();
		Date currentDateAsDate = Date.valueOf(currentDate);
		if(userLogin != null) {
			if(comment != "") {
				Product p = productService.getProductById(id);
				Comment c = new Comment(userLogin, p, comment, currentDateAsDate);
				commentService.saveComment(c);
			}
		}
		return "redirect:/product/" + id;
	}
	
	@GetMapping("/delete-comment/{id}")
	public String deleteComment(@PathVariable int id) {
		User userLogin = (User) session.getAttribute("userLogin");
		Comment comment = commentService.getCommentById(id);
		int productId = 0;
		if(userLogin != null) {
			if(comment.getIdUser().getId() == userLogin.getId()) {
				productId = comment.getIdProduct().getId();
				commentService.deleteComment(id);
			}else {
				return "redirect:/product/" + comment.getIdProduct().getId();
			}
		}else {
			return "redirect:/product/" + comment.getIdProduct().getId();
		}
		return "redirect:/product/" + productId;
	}
	
	
}
