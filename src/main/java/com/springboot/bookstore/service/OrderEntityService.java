package com.springboot.bookstore.service;

import java.util.List;

import com.springboot.bookstore.entity.OrderEntity;

public interface OrderEntityService {

    List<OrderEntity> getAllOrderEntityByUserId(int idUser);
    
    OrderEntity saveOrderEntity(OrderEntity orderEntity);
    
    OrderEntity getOrderEntityById(int id);
    
    void deleteOrderEntity(int id);
    
}
