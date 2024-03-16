package com.springboot.bookstore.service.impl;

import java.util.List;

import com.springboot.bookstore.entity.OrderEntity;
import com.springboot.bookstore.repository.OrderEntityRepository;
import com.springboot.bookstore.service.OrderEntityService;

public class OrderEntityServiceImpl implements OrderEntityService{

	private OrderEntityRepository orderEntityRepository;

	public OrderEntityServiceImpl(OrderEntityRepository orderEntityRepository) {
		super();
		this.orderEntityRepository = orderEntityRepository;
	}

	@Override
	public List<OrderEntity> getAllOrderEntityByUserId(int id_user) {
        return orderEntityRepository.findAllByUserId(id_user);
    }

	@Override
	public OrderEntity saveOrderEntity(OrderEntity OrderEntity) {
		return orderEntityRepository.save(OrderEntity);
	}

	@Override
	public OrderEntity getOrderEntityById(int id) {
		return orderEntityRepository.findById(id).get();
	}

	@Override
	public void deleteOrderEntity(int id) {
		orderEntityRepository.deleteById(id);
	}
	
	
	
}
