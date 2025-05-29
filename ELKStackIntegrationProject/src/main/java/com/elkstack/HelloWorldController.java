package com.elkstack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@GetMapping("/hello")
	public String hello() {
		logger.info("Hello World! Logging from Spring Boot application");
		return "Hello World!";
	}
}
