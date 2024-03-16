package com.springboot.bookstore.controller;

import org.springframework.stereotype.Controller;

import com.springboot.bookstore.service.OrderDetailService;

@Controller
public class OrderDetailController {

	private OrderDetailService orderDetailService;

	public OrderDetailController(OrderDetailService orderDetailService) {
		super();
		this.orderDetailService = orderDetailService;
	}
	
	
	
}
