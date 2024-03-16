package com.springboot.bookstore.controller;

import org.springframework.stereotype.Controller;

import com.springboot.bookstore.service.AuthorService;

@Controller
public class AuthorController {
	
	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}
	
	

}
