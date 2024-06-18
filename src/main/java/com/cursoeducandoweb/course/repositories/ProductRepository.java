package com.cursoeducandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoeducandoweb.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
