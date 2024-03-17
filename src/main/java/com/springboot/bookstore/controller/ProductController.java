package com.springboot.bookstore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springboot.bookstore.entity.Comment;
import com.springboot.bookstore.entity.Product;
import com.springboot.bookstore.entity.User;
import com.springboot.bookstore.service.CommentService;
import com.springboot.bookstore.service.ProductService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private HttpSession session;
	
	@GetMapping("/product/{id}")
	public String productDetail(@PathVariable int id, Model model) {
		Product p = productService.getProductById(id);
		List<Comment> comments = commentService.getAllCommentByIdProduct(id);
		model.addAttribute("product", p);
		model.addAttribute("comments", comments);
		return "product_detail";
	}
	
	@GetMapping("/inc-likes/{id}")
	public String incLikes(@PathVariable int id, Model model) {
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin != null) {
			Product p = productService.incLikes(id);
			productService.updateProduct(p);
		}else {
			return "redirect:/product/" + id;
		}
		
		return "redirect:/product/" + id;
	}
}
