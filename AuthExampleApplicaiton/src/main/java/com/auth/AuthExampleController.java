package com.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthExampleController {

	@GetMapping("/")
	public String home() {
		return "Welcome to the home page!";
	}
	
	@GetMapping("/user")
	public String user() {
		return "Welcome User!";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Welcome Admin!";
	}
}
