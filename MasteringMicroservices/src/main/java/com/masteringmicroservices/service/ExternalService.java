package com.masteringmicroservices.service;

public interface ExternalService {
	
	public String callExternalService();
	public String fallback(Throwable t);

}
