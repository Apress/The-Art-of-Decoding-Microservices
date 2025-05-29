package com.masteringmicroservices.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.masteringmicroservices.exception.OrderNotFoundException;
import com.masteringmicroservices.model.Order;
import com.masteringmicroservices.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	List<Order> orders= new ArrayList<>();
	
	
	@Override()
	public Order saveOrder(Order order) {
		
		orders.add(order);
		return order;
	}


	@Override
	public Order getOrder(Long id) {
		int found = 0;
		Order order = null;
		for(Order ord:orders) {
			if(ord.getOrderId() == id) {
				found = 1;
				
			}
		}
		if(found == 1)
			return order;
		else
			throw new OrderNotFoundException("Order id "+id+" not exists.");
	}
	
	

}
