package com.cloud.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/medicine-management/**")
						.uri("lb://medicine-management"))
				.route(p -> p.path("/medicine-registration/**")
						.uri("lb://medicine-registration"))
				.route(p -> p.path("/medicine-search/**")
						.uri("lb://medicine-search"))
				.route(p -> p.path("/symptom-search/**")
						.uri("lb://symptom-search"))
				.build();
	}

}
