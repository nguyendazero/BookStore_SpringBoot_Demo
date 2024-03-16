package com.springboot.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookstore.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
	List<CartItem> findAllByCartId(int cartId);
}
