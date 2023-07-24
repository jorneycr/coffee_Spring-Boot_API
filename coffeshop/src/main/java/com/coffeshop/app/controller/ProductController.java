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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeshop.app.entity.Product;
import com.coffeshop.app.repository.ProductRepository;
import com.coffeshop.app.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	//Create a new product
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Product product){
		Product newProduct = new Product();
		newProduct = productRepository.save(product);
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(newProduct != null) {
			map.put("id", newProduct.getId());
	        map.put("status", 200);
	        return new ResponseEntity<Object>(map,HttpStatus.CREATED);
			
		}
		return ResponseEntity.notFound().build();
	
	}
	
	//Read a product
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable Long id) {
		Optional<Product> oProduct = productRepository.findById(id);
		if(!oProduct.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oProduct);
	}
	
	//Update a product
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Product productDetais, @PathVariable Long id){
		Optional<Product> product = productRepository.findById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if(!product.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		product.get().setImage(productDetais.getImage());
		product.get().setName(productDetais.getName());
		product.get().setPrice(productDetais.getPrice());
		productRepository.save(product.get());
		
		 map.put("status", 200);
	     return new ResponseEntity<Object>(map,HttpStatus.CREATED);
		
	}
	
	//Delete user
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id) {
		Optional<Product> oProduct = productRepository.findById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if(!oProduct.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		productRepository.deleteById(id);
		map.put("status", 200);
	    return new ResponseEntity<Object>(map,HttpStatus.OK);
		
	}
	
	//Read all Products
	@GetMapping
	public ResponseEntity<?> getAll (){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Product> products = StreamSupport
				.stream(productRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		map.put("items", products);
        map.put("status", 200);
        return new ResponseEntity<Object>(map,HttpStatus.OK);
        
	}
	
	
}
