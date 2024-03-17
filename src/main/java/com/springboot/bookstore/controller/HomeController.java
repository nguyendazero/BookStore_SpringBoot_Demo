package com.springboot.bookstore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.bookstore.entity.Category;
import com.springboot.bookstore.entity.Product;
import com.springboot.bookstore.service.CategoryService;
import com.springboot.bookstore.service.ProductService;

@Controller
public class HomeController {
	private ProductService productService;
	private CategoryService categoryService;
	
	public HomeController(ProductService productService, CategoryService categoryService) {
		super();
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		List<Product> products = productService.getAllProducts();
		List<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		return "home";
	};
	
	
}
