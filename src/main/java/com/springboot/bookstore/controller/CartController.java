package com.springboot.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springboot.bookstore.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;


	
	
	
}
