package com.masteringmicroservices.asynch;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
	
	public OrderService(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void createOrder(String orderId) {
		OrderEvent event = new OrderEvent(orderId, "CREATED");
		kafkaTemplate.send("orders", event);
		System.out.println("Order event sent for orderId: " + orderId);
	}
	
}
