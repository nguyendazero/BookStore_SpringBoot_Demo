package com.springboot.bookstore.service;

import java.util.List;

import com.springboot.bookstore.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();
	
	Product saveProduct(Product Product);
	
	Product getProductById(int id);
	
	Product updateProduct(Product Product);
	
	void deleteProduct(int id);

	List<Product> getAllProductsByIdCategory(int category);
	
	Product incLikes(int id);
	
	List<Product> searchProducts(String search, List<Product> p);
	
	List<Product> getProductsGiamGia();
	
	List<Product> getProductsHetHang();
	
	List<Product> getProductsHot();
	
}
