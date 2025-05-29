package com.masteringmicroservices.configuration;

import org.springframework.amqp.core.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Bean
	public Queue queue() {
		return new Queue("rabbitQueue");
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange("orderExchange");
	}
	
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("orderRountingKey");
	}
}
