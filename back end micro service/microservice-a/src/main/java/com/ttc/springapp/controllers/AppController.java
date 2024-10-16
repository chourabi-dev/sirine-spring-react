package com.ttc.springapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/micro-service-a")
public class AppController {
	
	
	@GetMapping("/products")
	public ResponseEntity<?> getProrudcts(){
		List<String> products = new ArrayList<String>();
		products.add("macbook");
		products.add("sony headset");
		products.add("HP PAVILLION");
		
		return ResponseEntity.ok(products);
	}

}
