package com.springboot.bookstore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.springboot.bookstore.entity.Product;
import com.springboot.bookstore.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/products")
	public String getAllProducts(Model model) {
		List<Product> products = productService.getAllProducts();
		 model.addAttribute("products", products);
		 return "products";
	}
	
}
