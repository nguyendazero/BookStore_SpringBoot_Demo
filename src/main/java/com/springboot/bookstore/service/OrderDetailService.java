package com.springboot.bookstore.service;

import java.util.List;

import com.springboot.bookstore.entity.OrderDetail;

public interface OrderDetailService {

	List<OrderDetail> getAllOrderDetailById(int id);
	
}
