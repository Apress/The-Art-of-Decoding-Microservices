package com.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		
		if(isDatabaseUp()) {
			return Health.up().withDetail("Message", "Database is up").build();					
		}else {
			return Health.up().withDetail("Message", "Database is down").build();	
		}
	}

	private boolean isDatabaseUp() {
		return true;
	}
}
