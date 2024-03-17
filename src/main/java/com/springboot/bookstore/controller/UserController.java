package com.springboot.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.bookstore.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
//	public String checkLogin() {
//		
//	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
//	public String checkRegister() {
//		
//	}
	
	public String logout() {
		return "redirect:/home";
	}
	
}
