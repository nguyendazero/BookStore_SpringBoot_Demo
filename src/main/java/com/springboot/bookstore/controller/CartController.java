package com.springboot.bookstore.controller;

import org.springframework.stereotype.Controller;

import com.springboot.bookstore.service.CartService;

@Controller
public class CartController {

	private CartService cartService;

	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}
	
	
	
}
