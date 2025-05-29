package com.masteringmicroservices.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayRoutingConfig {

	public RouteLocator locator;
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	    return builder.routes()
	        .route("order-service-client", p -> p
	            .path("/client/**")
	            .filters(f -> f.requestRateLimiter(c-> c.setRateLimiter(redisRateLimiter())))
	            .uri("lb://order-service-client"))
	        .build();
	}
	
	public RedisRateLimiter redisRateLimiter() {
		return new RedisRateLimiter(10,20);
	}
	
}
