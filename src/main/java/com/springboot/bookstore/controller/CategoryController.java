package com.springboot.bookstore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.bookstore.entity.Category;
import com.springboot.bookstore.entity.Product;
import com.springboot.bookstore.service.CategoryService;
import com.springboot.bookstore.service.ProductService;

@Controller
public class CategoryController {

	@Autowired
    private CategoryService categoryService;
	@Autowired
    private ProductService productService;

	@GetMapping("/categories/{id}")
	public String getProductBycategory(@PathVariable int id, Model model) {
		List<Product> p = productService.getAllProductsByIdCategory(id);
		List<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("products", p);
		model.addAttribute("categories", categories);
		return "category";
	}
    
}

