package com.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class UserControllerV2 {

	@GetMapping("/users")
	public String getUsersV2() {
		return "Version 2: List of users with additional fields";
	}
	
	@GetMapping(value = "/users", headers = "X-API-Version=2")
	public String getUsersV2HeaderVersion() {
		return "Version 2: List of users with additional fields (header version)";
	}
}
