package com.provider;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/products")
public class ProductController {

	public List<Product> getAllProducts(){
		
		return Arrays.asList(
				new Product(1L, "Product 1", "Description 1"),
				new Product(2L, "Product 2", "Description 2")
				);
				
	}
}
