package com.cursoeducandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoeducandoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
