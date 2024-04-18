package com.app.mobile.gateway;

import java.util.ArrayList;

import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;


@SpringBootApplication
@EnableWebFlux
public class WebGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebGatewayApplication.class, args);
	}
	

	

	
//	@Bean
//	 public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//	  return builder
//	    .routes()
//	    .route(r -> r.path("/product-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://product-service"))
//	    .route(r -> r.path("/price-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://logout"))
//	    
//	    .build();
//	 }
	
	
	
	
}
