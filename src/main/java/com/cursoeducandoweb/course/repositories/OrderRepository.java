package com.cursoeducandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoeducandoweb.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
