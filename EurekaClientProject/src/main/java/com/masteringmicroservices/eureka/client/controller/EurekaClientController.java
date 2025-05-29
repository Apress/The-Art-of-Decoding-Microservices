package com.masteringmicroservices.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class EurekaClientController {
	
	@Autowired
	private RestTemplate restTemplate;

	public String getOrder() {
		return restTemplate.getForObject("http://MASTERING-MICROSERVICE/orders", String.class);
	}
}
