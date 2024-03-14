package com.springboot.bookstore.service;

import java.util.List;

import com.springboot.bookstore.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();
	
	Product saveProduct(Product Product);
	
	Product getProductById(int id);
	
	Product updateProduct(Product Product);
	
	void deleteProduct(int id);
	
}
