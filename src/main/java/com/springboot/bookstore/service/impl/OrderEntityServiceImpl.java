package com.springboot.bookstore.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.bookstore.entity.OrderEntity;
import com.springboot.bookstore.repository.OrderEntityRepository;
import com.springboot.bookstore.service.OrderEntityService;

@Service 
public class OrderEntityServiceImpl implements OrderEntityService{

    private OrderEntityRepository orderEntityRepository;

    public OrderEntityServiceImpl(OrderEntityRepository orderEntityRepository) {
        super();
        this.orderEntityRepository = orderEntityRepository;
    }

    @Override
    public List<OrderEntity> getAllOrderEntityByUserId(int idUser) {
        return orderEntityRepository.findAllByUserId(idUser);
    }

    @Override
    public OrderEntity saveOrderEntity(OrderEntity orderEntity) {
        return orderEntityRepository.save(orderEntity);
    }

    @Override
    public OrderEntity getOrderEntityById(int id) {
        return orderEntityRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrderEntity(int id) {
        orderEntityRepository.deleteById(id);
    } 
}
