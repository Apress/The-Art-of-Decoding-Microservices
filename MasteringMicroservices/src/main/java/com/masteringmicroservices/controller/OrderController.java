package com.masteringmicroservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masteringmicroservices.exception.OrderNotFoundException;
import com.masteringmicroservices.model.Order;
import com.masteringmicroservices.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable Long id){
		ResponseEntity<Order> resp = null;
		
		try {
		      Order order = orderService.getOrder(id);
		      resp = new ResponseEntity<Order>(order, HttpStatus.OK);
		}catch(OrderNotFoundException e) {
			throw e;
		}
		return resp;
	}
	
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		Order savedOrder = orderService.saveOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
	}
	
}
