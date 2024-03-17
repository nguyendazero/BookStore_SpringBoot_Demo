package com.springboot.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookstore.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findAllByCategoryId(int category);

}
