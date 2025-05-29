package com.masteringmicroservices.service;

import com.masteringmicroservices.model.Order;

public interface OrderService {

	public Order saveOrder(Order order);
	
	public Order getOrder(Long id);
}
