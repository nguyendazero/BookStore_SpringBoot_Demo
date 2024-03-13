package com.springboot.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookstore.entity.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Integer>{

}
