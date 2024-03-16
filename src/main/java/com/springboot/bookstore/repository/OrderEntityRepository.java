package com.springboot.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bookstore.entity.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Integer>{

	@Query("SELECT o FROM OrderEntity o WHERE o.idUser.id = :idUser")
    List<OrderEntity> findAllByUserId(int idUser);
}
