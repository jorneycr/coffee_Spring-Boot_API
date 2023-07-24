package com.coffeshop.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.coffeshop.app.entity.Order;
import com.coffeshop.app.repository.OrderRepository;


public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional(readOnly = true)
	public Iterable<Order> findAll() {
		
		return orderRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Optional<Order> findById(Long id) {
		
		return orderRepository.findById(id);
	}

	@Override
	@Transactional
	public Order save(Order orders) {
		
		return orderRepository.save(orders);
	}
	

}
