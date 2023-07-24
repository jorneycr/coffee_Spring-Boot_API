package com.coffeshop.app.service;

import java.util.Optional;

import com.coffeshop.app.entity.Product;

public interface ProductService {
	public Iterable<Product> findAll();
	
	public Optional<Product> findById(Long id);
	
	public Product save(Product product);
	
	public void deleteById(Long id);
}
