package com.ttc.springapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ttc.springapp.dto.ProductModel;
import org.springframework.http.*;

@RestController
@RequestMapping("/micro-service-b")
public class AppController {
	 private RestTemplate restTemplate = new RestTemplate();
	 
	 public int checkIdentity(String token) {
		 
		    try {
	        	 String url = "http://localhost:9076/api/auth/verify-identity";
	        	 // Create headers
	             HttpHeaders headers = new HttpHeaders();
	             headers.setContentType(MediaType.APPLICATION_JSON);

	             // Create JSON body
	             
		    //String jsonBody = "{ \"token\":\"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjaG91cmFiaSIsImlhdCI6MTcyODkwNzcwOCwiZXhwIjoxNzI4OTk0MTA4fQ.hBw5hSpEguHZx3YCTNIsgLrDwFJD5htfYlK2ma2X77Q\" }";
	             String jsonBody = "{ \"token\":\"" + token + "\" }";
	             // Create HttpEntity with body and headers
	             HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

	             // Make the POST request and capture the response
	             ResponseEntity<String> res2 = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

	             // Check for 200 OK and return response
	             if (res2.getStatusCode() == HttpStatus.OK) {
	                 String msg = res2.getBody();
	                 
	                return 1;
	             } else {
	            	 return 0;
	             }
	         } catch (Exception e) {
	             // Handle any exceptions
	        	 return 0;
	         }
	 }
	 
 
	@GetMapping("/stock")
	public ResponseEntity<?> getProrudcts( @RequestHeader(HttpHeaders.AUTHORIZATION) String token ){
		
		int nbrPRODUCTS = 0;
		
		// COMMUNICATION BEWEEN MECRO SERVICE B AND A
		 
			    
			    if( checkIdentity(token)  == 1 ) {
			    		
			    	ResponseEntity<?> responseEntity = new RestTemplate().exchange(
							"http://localhost:9071/micro-service-a/products",
					        HttpMethod.GET,
					        null,
					        new ParameterizedTypeReference<List<String>>() {}
					         );     
						    Object response = responseEntity.getBody();       

						    List<String> products =(List<String> )response;	
			    	 return ResponseEntity.ok("we have "+products.size() +" products");
			    }else {
			    	 return ResponseEntity.status(401).body("not connected");
			    }
			    
	    
		
	}
}
