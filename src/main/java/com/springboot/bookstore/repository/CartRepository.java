package com.springboot.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookstore.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
