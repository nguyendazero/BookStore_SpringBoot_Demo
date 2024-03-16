package com.springboot.bookstore.controller;

import org.springframework.stereotype.Controller;

import com.springboot.bookstore.service.CartItemService;

@Controller
public class CartItemController {
	
	private CartItemService cartItemService;

	public CartItemController(CartItemService cartItemService) {
		super();
		this.cartItemService = cartItemService;
	}
	
	
	
}
