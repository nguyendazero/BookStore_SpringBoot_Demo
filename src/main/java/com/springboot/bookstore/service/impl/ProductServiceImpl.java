package com.springboot.bookstore.service.impl;

import java.util.List;

import com.springboot.bookstore.entity.Product;
import com.springboot.bookstore.repository.ProductRepository;
import com.springboot.bookstore.service.ProductService;

public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product saveProduct(Product Product) {
		return productRepository.save(Product);
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product updateProduct(Product Product) {
		return productRepository.save(Product);
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);	
	}

}
