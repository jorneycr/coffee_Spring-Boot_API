package com.coffeshop.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.coffeshop.app.entity.Order;
import com.coffeshop.app.entity.Product;
import com.coffeshop.app.repository.OrderRepository;
import com.coffeshop.app.repository.ProductRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderReposotory;
	
	@Autowired
	private ProductRepository productReposotory;
	
	
	@PostMapping
	public ResponseEntity<?> createOrder(@RequestBody Order order){
		
		Optional<Product> oProduct = productReposotory.findById(order.getIdProduct());
		
		Map<String, Object> map = new HashMap<String, Object>();
		//newOrder = orderReposotory.save(order);
		if (!oProduct.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Order newOrder = new Order();
		newOrder = orderReposotory.save(order);
		map.put("order", oProduct.get().getId());
        map.put("status", 200);
        return new ResponseEntity<Object>(map,HttpStatus.CREATED);
	}
	
	//Read all orders
	@GetMapping
	public ResponseEntity<?> getAll (){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Order> orders = StreamSupport
				.stream(orderReposotory.findAll().spliterator(), false)
				.collect(Collectors.toList());
		map.put("items", orders);
        map.put("status", 200);
        return new ResponseEntity<Object>(map,HttpStatus.OK);
	}
	
	//Read a order
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable Long id) {
		Optional<Order> oOrder = orderReposotory.findById(id);
		if(!oOrder.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oOrder);
	}
	
	//Update a order
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Order oderDetails, @PathVariable Long id){
		Optional<Order> order = orderReposotory.findById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if(!order.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		order.get().setStatus(oderDetails.getStatus());
		order.get().setUpdatedAt(System.currentTimeMillis());
		orderReposotory.save(order.get());
		 map.put("status", 200);
	     return new ResponseEntity<Object>(map,HttpStatus.CREATED);
		
	}
	

}
