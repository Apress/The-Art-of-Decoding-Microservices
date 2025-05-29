package com.consumer;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.provider.Product;

@Service
public class ProductServiceConsumer {

	private final RestTemplate restTemplate;
	
	
	public ProductServiceConsumer(RestTemplate restTemplate) {
		this.restTemplate = restTemplate; 
	}
	
	public List<Product> getAllProducts(){
		return Arrays.asList(restTemplate.getForObject("http://localhost:8080/api/products", Product.class));
				
	}
}
