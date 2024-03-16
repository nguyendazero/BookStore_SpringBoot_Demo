package com.springboot.bookstore.controller;

import org.springframework.stereotype.Controller;

import com.springboot.bookstore.service.OrderEntityService;

@Controller
public class OrderEntityController {

	private OrderEntityService orderEntityService;

	public OrderEntityController(OrderEntityService orderEntityService) {
		super();
		this.orderEntityService = orderEntityService;
	}
	
	
	
}
