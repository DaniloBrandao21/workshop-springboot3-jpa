package com.cursoeducandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoeducandoweb.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
