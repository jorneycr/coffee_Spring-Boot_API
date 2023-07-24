package com.coffeshop.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffeshop.app.entity.Product;
import com.coffeshop.app.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Product> findAll() {
		
		return productRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Product> findById(Long id) {
		
		return productRepository.findById(id);
	}

	@Override
	@Transactional
	public Product save(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		productRepository.deleteById(id);
		
	}

}
