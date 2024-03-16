package com.springboot.bookstore.service.impl;

import java.util.List;

import com.springboot.bookstore.entity.OrderDetail;
import com.springboot.bookstore.repository.OrderDetailRepository;
import com.springboot.bookstore.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService{

	private OrderDetailRepository orderDetailRepository;

	public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
		super();
		this.orderDetailRepository = orderDetailRepository;
	}

	@Override
	public List<OrderDetail> getAllOrderDetailById(int id) {
        return orderDetailRepository.findAllByOrderId(id);
    }
	
	
	
}
