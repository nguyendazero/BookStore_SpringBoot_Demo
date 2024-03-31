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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


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
		return "home";
	}
	
	@GetMapping("/manager-categories")
	public String getAllCategory(Model model) {
		List<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("categories", categories);
		return "manager_categories";
	}
	
	@PostMapping("/categories/add")
	public String addCategory(@RequestParam("name") String name) {
		Category c = new Category();
		c.setName(name);
		categoryService.saveCategory(c);
		return "redirect:/manager-categories";
	}
	
	@GetMapping("/categories/delete/{id}")
	public String deleleCategory(@RequestParam("categoryId") int categoryId) {
		categoryService.deleteCategory(categoryId);
		return "redirect:/manager-categories";
	}
    
	@GetMapping("/categories/edit/{id}")
	public String editCategory(
				@RequestParam("categoryId") int categoryId,
				@RequestParam("categoryName") String categoryName) {
		Category c = categoryService.getCategoryById(categoryId);
		c.setName(categoryName);
		categoryService.updateCategory(c);
		return "redirect:/manager-categories";
	}
	
}

