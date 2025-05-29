package com.masteringmicroservices.asynch;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	public void consume(OrderEvent event) {
		System.out.println("Received order event: " + event.getOrderId() +" with status: "+ event.getOrderStatus());
	}
}
