package com.springboot.bookstore.controller;

import org.springframework.stereotype.Controller;

import com.springboot.bookstore.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	
}
