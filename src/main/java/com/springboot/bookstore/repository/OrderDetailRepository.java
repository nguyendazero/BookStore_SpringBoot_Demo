package com.springboot.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookstore.entity.OrderDetail;
import com.springboot.bookstore.entity.OrderDetailId;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId>{

	List<OrderDetail> findAllByOrderId(int id);

}
