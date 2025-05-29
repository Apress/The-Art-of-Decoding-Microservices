package com.masteringmicroservices.asynch;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.masteringmicroservices.model.Order;

public class OrderSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendOrder(Order order) {
		rabbitTemplate.convertAndSend("orderExchange", "orderRoutingKEy", order);
	}
	
}
