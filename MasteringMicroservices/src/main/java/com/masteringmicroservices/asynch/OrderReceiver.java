package com.masteringmicroservices.asynch;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.masteringmicroservices.model.Order;

@Component
public class OrderReceiver {

	@RabbitListener(queues = "orderQueue")
	public void receiveOrder(Order order) {
		
		System.out.println("Received Order: "+order);
	}
	
}
