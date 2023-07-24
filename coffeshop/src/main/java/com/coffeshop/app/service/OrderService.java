package com.coffeshop.app.service;

import java.util.Optional;

import com.coffeshop.app.entity.Order;


public interface OrderService {

	public Iterable<Order> findAll();
	
	public Optional<Order> findById(Long id);
	
	public Order save(Order order);
}

