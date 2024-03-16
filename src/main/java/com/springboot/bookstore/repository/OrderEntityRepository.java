package com.springboot.bookstore.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookstore.entity.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Integer>{

	List<OrderEntity> findAllByUserId(int id_user);
}
