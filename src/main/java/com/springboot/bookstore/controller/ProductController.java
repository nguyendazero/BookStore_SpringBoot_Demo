package com.springboot.bookstore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.springboot.bookstore.entity.Category;
import com.springboot.bookstore.entity.Product;
import com.springboot.bookstore.service.AuthorService;
import com.springboot.bookstore.service.CategoryService;
import com.springboot.bookstore.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

	private ProductService productService;
	private CategoryService categoryService;
	private AuthorService authorService;
	
	public ProductController(ProductService productService, CategoryService categoryService,
			AuthorService authorService) {
		super();
		this.productService = productService;
		this.categoryService = categoryService;
		this.authorService = authorService;
	}
	
	@GetMapping("/product/{id}")
	public String productDetail(@PathVariable int id, Model model) {
		Product p = productService.getProductById(id);
		model.addAttribute("product", p);
		return "product_detail";
	}
	
}
