package com.springboot.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springboot.bookstore.service.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;

}
