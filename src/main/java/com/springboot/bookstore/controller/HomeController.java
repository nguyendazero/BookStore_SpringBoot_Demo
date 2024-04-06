package com.springboot.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.bookstore.entity.Category;
import com.springboot.bookstore.entity.Product;
import com.springboot.bookstore.service.CategoryService;
import com.springboot.bookstore.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private HttpSession session;
	
	
	@GetMapping("/home")
	public String home(Model model) {
		List<Product> products = productService.getAllProducts();
		List<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		
		String error = (String) session.getAttribute("error");
		session.setAttribute("error", null);
		model.addAttribute("error", error);
		return "home";
	};
	
	@GetMapping("/home-admin")
	public String homeAdmin(Model model) {
		List<Product> products = productService.getAllProducts();
		List<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		return "home_admin";
	};
	
	@GetMapping("/home/search/{search}")
	public String homeSearch(Model model) {
		List<Product> searchResult = (List<Product>) session.getAttribute("searchResult");
		List<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("products", searchResult);
		model.addAttribute("categories", categories);
		return "home";
	};
}
