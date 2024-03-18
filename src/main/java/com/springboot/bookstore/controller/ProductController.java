package com.springboot.bookstore.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import org.springframework.web.bind.annotation.RequestParam;


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
	
	@GetMapping("/search")
	public String search(@RequestParam("search") String search, Model model) {
		List<Product> products = productService.getAllProducts();
		List<Product> searchResult = productService.searchProducts(search, products);
		try {
			search = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		session.setAttribute("searchResult", searchResult);
		return "redirect:/home/search/"+search;
	}
	
}
