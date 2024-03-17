package com.springboot.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springboot.bookstore.service.CartItemService;

@Controller
public class CartItemController {
	
	@Autowired
	private CartItemService cartItemService;

	
	
	
}
