package com.masteringmicroservices.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.masteringmicroservices.asynch.OrderEvent;

public class KafkaConfig {

	@Bean
	public ProducerFactory<String, OrderEvent> producerFactory(){
		
		Map<String, Object> config = new HashMap<>();
		
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializable.class);
		return new DefaultKafkaProducerFactory<String, OrderEvent>(config);
	}
	
	
	public KafkaTemplate<String, OrderEvent> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
	
}
