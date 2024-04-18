//package com.app.mobile.api.logout;
//
//import java.net.URI;
//import java.net.URL;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.security.authorization.AuthorizationDecision;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.security.web.server.WebFilterExchange;
//import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
//import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
//import org.springframework.security.web.server.authorization.AuthorizationContext;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsWebFilter;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.server.ServerWebExchange;
//
//import lombok.RequiredArgsConstructor;
//import reactor.core.publisher.Mono;
//import java.net.URL;
//
//@Configuration
//@EnableWebFluxSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
////
//////	 @Bean
//////	    public InMemoryUserDetailsManager userDetailsService() {
//////	        UserDetails user1 = User.withUsername("user1")
//////	            .password(passwordEncoder().encode("user1Pass"))
//////	            .roles("USER")
//////	            .build();
//////	        return new InMemoryUserDetailsManager(user1);
//////	    }
//////	 
////
//////	@Bean
//////	public ServerAuthenticationFailureHandler authenticationFailureHandler() {
//////		return new CustomAuthenticationFailureHandler();
//////	}
////
//////	    @Bean
//////	    public PasswordEncoder passwordEncoder() {
//////	        return new BCryptPasswordEncoder();
//////	    }
////
//////	    @Bean
//////	    public SecurityWebFilterChain apiWebFilterChain(ServerHttpSecurity http) {
//////	        return 		http
//////	                    .authorizeExchange()
//////	                    .pathMatchers("/api/**")
//////	                    //.authenticated()
//////	                    //.anyExchange()
//////	                    .permitAll()
//////	                    .and()
//////	                    .httpBasic()
//////	                    .and()
//////	                    .build();
//////	    }
////
////	private Mono<AuthorizationDecision> currentUserMatchesPath(Mono<Authentication> authentication,
////			AuthorizationContext context) {
////
////		return authentication.map(a -> context.getVariables().get("user").equals(a.getName()))
////				.map(AuthorizationDecision::new);
////
////	}
////
//////@Bean
//////public ReactiveUserDetailsService userDetailsService(UserRepository users) {
//////
//////return username -> users.findByUsername(username)
//////.map(u -> User
//////.withUsername(u.getUsername()).password(u.getPassword())
//////.authorities(u.getRoles().toArray(new String[0]))
//////.accountExpired(!u.isActive())
//////.credentialsExpired(!u.isActive())
//////.disabled(!u.isActive())
//////.accountLocked(!u.isActive())
//////.build()
//////);
//////}
//////
//////@Bean
//////public ReactiveAuthenticationManager reactiveAuthenticationManager(ReactiveUserDetailsService userDetailsService,
//////                      PasswordEncoder passwordEncoder) {
//////var authenticationManager = new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService);
//////authenticationManager.setPasswordEncoder(passwordEncoder);
//////return authenticationManager;
//////}
////
////	final String PATH_POSTS = "/api/*";
////	
////	private static final String[] AUTH_WHITELIST = {
////	        "/api/v1/auth/**",
////	        "/v3/api-docs/**",
////	        "/v3/api-docs.yaml",
////	        "/swagger-ui/**",
////	        "/swagger-ui.html"
////	};
////
////	@Bean
////	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
////
//////		 serverHttpSecurity.addFilterBefore(new CustomOncePerRequestFilter(),
//////		 SecurityWebFiltersOrder.AUTHENTICATION);
////
//////		 serverHttpSecurity
//////	            .csrf().disable()
//////	            .cors().disable()
//////	            .authorizeExchange()
//////	                .pathMatchers(HttpMethod.POST, "/api/login").permitAll()
//////	                .pathMatchers("/api/**").authenticated().and()
//////		               .addFilterAfter(new CustomOncePerRequestFilter(), SecurityWebFiltersOrder.HTTP_BASIC);
////
////		serverHttpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable)
////		.cors().disable()
////				.httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
////				// .authenticationManager(reactiveAuthenticationManager)
////				// .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
////				.authorizeExchange(it -> 
////				       it.pathMatchers(HttpMethod.POST, PATH_POSTS).permitAll()
////				         .pathMatchers("/website/*").permitAll()
////						.pathMatchers(HttpMethod.DELETE, PATH_POSTS).hasRole("ADMIN")
////						.pathMatchers(PATH_POSTS).authenticated()
////					//	.pathMatchers("/me").authenticated()
////					//	.pathMatchers("/users/{user}/**")
////					//	.access(this::currentUserMatchesPath).anyExchange().permitAll()
////
////						
////						
////						.pathMatchers("/**").permitAll()
////						.pathMatchers(AUTH_WHITELIST).permitAll()
////						
//////						.authenticated().and().httpBasic()
//////						.and().formLogin()
//////						.authenticationFailureHandler(authenticationFailureHandler())
//////						.authenticationSuccessHandler(new ServerAuthenticationSuccessHandler() {
//////							@Override
//////							public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange,
//////									Authentication authentication) {
//////								org.springframework.http.server.reactive.ServerHttpResponse response = webFilterExchange
//////										.getExchange().getResponse();
//////								response.setStatusCode(HttpStatus.SEE_OTHER);
//////								response.getHeaders().setLocation(URI.create("http://192.168.1.193:3333/")); 
//////								// TODO Auto-generated method stub
//////								return response.setComplete();
//////							}
//////						}
//////								)
////
////				);
////				
////			//	.addFilterAt(new CustomOncePerRequestFilter(), SecurityWebFiltersOrder.HTTP_BASIC);
////
////		// .build();
////
//////		serverHttpSecurity.csrf().disable()
//////		                  .cors().disable()
//////		                  .authorizeExchange()
//////		           
//////		           
//////                    .pathMatchers(HttpMethod.POST, "/api/login").permitAll()
//////		            .and().addFilterAfter(new CustomOncePerRequestFilter(), SecurityWebFiltersOrder.AUTHORIZATION).authorizeExchange()
//////
//////		            .pathMatchers("api/**").authenticated()
////
//////		            .authorizeExchange()
//////
//////		        .pathMatchers("/")
//////				.authenticated().and().httpBasic().and().formLogin()
//////				.authenticationFailureHandler(authenticationFailureHandler())
//////				.authenticationSuccessHandler(new ServerAuthenticationSuccessHandler() {
//////					@Override
//////					public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange,
//////							Authentication authentication) {
//////						ServerWebExchange exchange = webFilterExchange.getExchange();
//////						ServerHttpResponse response = exchange.getResponse();
//////
//////						// Set the status code for redirection
//////						response.setStatusCode(HttpStatus.SEE_OTHER);
//////
//////						// Set the redirection location (your default failure page URL)
//////						response.getHeaders().setLocation(URI.create("http://192.168.1.193:3333/")); // Replace with
//////																										// your default
//////																										// failure page
//////																										// URL
//////
//////						// Return a Mono indicating the completion of the redirection process
//////						return response.setComplete();
//////					}
//////				});
//////                 .and()
//////                 //.addFilterAt(new CustomOncePerRequestFilter(), SecurityWebFiltersOrder.AUTHORIZATION)
////
//////				.logout().logoutUrl("/logout");
////
////		return serverHttpSecurity.build();
////
//////    	return serverHttpSecurity
//////                .csrf().disable() // Disable CSRF protection
//////                .cors().disable()
//////                .authorizeExchange()
//////                .anyExchange().permitAll() // Permit all requests without authentication
//////                .and()
//////                .build();
////	}
//
////	@Bean
////	public CorsWebFilter corsWebFilter() {
////		CorsConfiguration corsConfig = new CorsConfiguration();
////		corsConfig.addAllowedOrigin("*"); // Allow requests from all origins
////		corsConfig.addAllowedMethod("*"); // Allow all HTTP methods
////		corsConfig.addAllowedHeader("*"); // Allow all headers
////		// corsConfig.setAllowCredentials(true); // Allow credentials (e.g., cookies)
////
////		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////		source.registerCorsConfiguration("/**", corsConfig); // Apply CORS configuration to all paths
////
////		return new CorsWebFilter(source);
////	}
//
//}
