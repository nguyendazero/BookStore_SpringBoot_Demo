package com.springboot.bookstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.bookstore.entity.Cart;

import com.springboot.bookstore.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@GetMapping("/cart/{id}")
	public String cart(@PathVariable("id") int userId, Model model) {
	    Cart cart = cartService.getCartByUser(userId);
	    model.addAttribute("cart", cart);

	    return "redirect:/cartItems/" + userId;
	}
	
	
	
	
	
	
}
