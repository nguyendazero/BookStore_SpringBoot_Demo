package com.springboot.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookstore.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}