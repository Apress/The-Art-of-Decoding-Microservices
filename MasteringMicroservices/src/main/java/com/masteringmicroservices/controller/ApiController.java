package com.masteringmicroservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masteringmicroservices.service.ExternalService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private ExternalService extenalService;
	
	@GetMapping("/external")
	public String callExternal() {
		return extenalService.callExternalService();
	}
	
}
