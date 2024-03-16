package com.springboot.bookstore.controller;

import org.springframework.stereotype.Controller;

import com.springboot.bookstore.service.CategoryService;

@Controller
public class CategoryController {

	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	
	
}
