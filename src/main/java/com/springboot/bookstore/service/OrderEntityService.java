package com.springboot.bookstore.service;

import java.util.List;

import com.springboot.bookstore.entity.OrderEntity;

public interface OrderEntityService {

	List<OrderEntity> getAllOrderEntityByUserId(int id_user);
	
	OrderEntity saveOrderEntity(OrderEntity OrderEntity);
	
	OrderEntity getOrderEntityById(int id);
	
	void deleteOrderEntity(int id);
	
}
