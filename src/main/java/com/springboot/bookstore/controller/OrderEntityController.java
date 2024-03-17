package com.springboot.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springboot.bookstore.service.OrderEntityService;

@Controller
public class OrderEntityController {

	@Autowired
	private OrderEntityService orderEntityService;

	
	
	
}
