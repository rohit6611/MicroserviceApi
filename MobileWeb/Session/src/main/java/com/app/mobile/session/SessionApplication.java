package com.app.mobile.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages="com.app.mobile")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.app.mobile")
@EntityScan(basePackages="com.app.mobile")
@PropertySources({
    //@PropertySource("classpath:jwtConfig.properties"),
	
	
    @PropertySource("file:\\D:\\ACMP\\MobileWeb\\MobileWeb\\Database\\src\\main\\resources\\application.properties")
})
public class SessionApplication implements WebFluxConfigurer{
	
	
	public static void main(String[] args) {
		SpringApplication.run(SessionApplication.class, args);
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
