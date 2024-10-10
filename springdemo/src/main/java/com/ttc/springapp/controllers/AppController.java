package com.ttc.springapp.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttc.springapp.dto.ProductModel;
import com.ttc.springapp.entities.Product;
import com.ttc.springapp.repositories.ProductRepo;

@RestController
@RequestMapping("/api/products")
public class AppController {
	
	@Autowired
	private ProductRepo productRepo;

	// test  /test => "hello world"
	
	// GET POST PUT DELETE
	
	@GetMapping("/test")
	public ResponseEntity<?> sayHello(){
		return ResponseEntity.ok("hello world");
	}
	
	
	
	
	// CRUD PRODUCT
	
	// get products list
	
	@GetMapping("/list")
	public ResponseEntity<?> list(){
		  
		return ResponseEntity.ok(productRepo.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(  @RequestBody ProductModel model  ){
		
		// 1 create the entity !!
		Product p = new Product();
		p.setProduct( model.getProduct() );
		p.setPrice(model.getPrice());
		p.setQuantity(model.getQuantity());
		
		// save the entity !! 
		return ResponseEntity.ok(this.productRepo.save(p));
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update( @PathVariable long id , @RequestBody ProductModel model  ){
		
		 
		Product p = this.productRepo.findById(id).get();
		
		p.setProduct( model.getProduct() );
		p.setPrice(model.getPrice());
		p.setQuantity(model.getQuantity());
		
		// save the entity !! 
		return ResponseEntity.ok(this.productRepo.save(p));
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete( @PathVariable long id    ){
		
		 
		Product p = this.productRepo.findById(id).get();
	 
		HashMap<String,String> res = new HashMap();
		
		this.productRepo.delete(p);
		
		res.put("message", "product deleted.");
		 
		return ResponseEntity.ok( res );
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
