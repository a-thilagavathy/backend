package com.project1.shop.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;

import com.project1.shop.entity.Jobs;

@Component
public interface OrderRepository extends JpaRepository<Jobs, Integer> {
	
	//void deleteById(int orderId);
}
