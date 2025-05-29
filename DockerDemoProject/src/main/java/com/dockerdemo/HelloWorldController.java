package com.dockerdemo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloWorldController {

	@GetMapping("/")
	public String hello() {
		return "Hello, World!";
	}
	
}
