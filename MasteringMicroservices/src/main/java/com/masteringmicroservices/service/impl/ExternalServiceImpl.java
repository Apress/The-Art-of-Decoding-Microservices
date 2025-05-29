package com.masteringmicroservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.masteringmicroservices.service.ExternalService;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class ExternalServiceImpl implements ExternalService {
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public ExternalServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	@Bulkhead(name="serviceBulkhead")
	@CircuitBreaker(name="serviceCB", fallbackMethod="fallback")
	@Retry(name="serviceRetry")
	public String callExternalService() {
		
		return restTemplate.getForObject("http://external-service/api", String.class);
	}

	@Override
	public String fallback(Throwable t) {
		return "Fallback response due to: " + t.getMessage();
	}

}
