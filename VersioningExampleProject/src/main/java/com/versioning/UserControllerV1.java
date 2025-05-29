package com.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserControllerV1 {

	@GetMapping("/users")
	public String getUsersV1() {
		return "Version 1: List of users";
	}
}
