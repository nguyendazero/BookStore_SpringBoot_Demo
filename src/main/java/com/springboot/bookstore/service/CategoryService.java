package com.springboot.bookstore.service;

import java.util.List;

import com.springboot.bookstore.entity.Category;

public interface CategoryService {

	List<Category> getAllCategorys();
	
	Category saveCategory(Category Category);
	
	Category getCategoryById(int id);
	
	Category updateCategory(Category Category);
	
	void deleteCategory(int id);
	
}
