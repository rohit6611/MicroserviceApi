package com.app.mobile.api.logout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;


@SpringBootApplication
//@ComponentScan("com.app.mobile.database")
@EnableWebFlux

public class LogoutApplication implements WebFluxConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(LogoutApplication.class, args);
	}
	
	  @Override
	    public void addCorsMappings(CorsRegistry corsRegistry) {
	        corsRegistry.addMapping("/**")
	          .allowedOrigins("*")
	          .allowedMethods("*")
	          .allowedHeaders("*")
	          .maxAge(3600);
	    }

	@Bean
	public CorsWebFilter corsWebFilter() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.addAllowedOrigin("*"); // Allow requests from all origins
		corsConfig.addAllowedMethod("*"); // Allow all HTTP methods
		corsConfig.addAllowedHeader("*"); // Allow all headers
		// corsConfig.setAllowCredentials(true); // Allow credentials (e.g., cookies)

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig); // Apply CORS configuration to all paths

		return new CorsWebFilter(source);
	}
	
}
