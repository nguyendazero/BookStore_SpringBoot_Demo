package com.springboot.bookstore.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.bookstore.entity.Category;
import com.springboot.bookstore.repository.CategoryRepository;
import com.springboot.bookstore.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> getAllCategorys() {
		return categoryRepository.findAll();
	}

	@Override
	public Category saveCategory(Category Category) {
		return categoryRepository.save(Category);
	}

	@Override
	public Category getCategoryById(int id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category updateCategory(Category Category) {
		return categoryRepository.save(Category);
	}

	@Override
	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
		
	}

}
