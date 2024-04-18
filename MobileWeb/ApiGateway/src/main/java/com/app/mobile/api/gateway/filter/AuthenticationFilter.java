package com.app.mobile.api.gateway.filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

//@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;

    //    @Autowired
//    private RestTemplate template;
//    @Autowired
//    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }
    String authHeader;
    @Override
    public GatewayFilter apply(Config config) {
        System.out.println("GatewayFilter.....");

    	
        return ((exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
            	
                System.out.println("GatewayFilter in side if");

                //header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }
                System.out.println("GatewayFilter checking token");


                authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                
                System.out.println("authHeader: "+authHeader);
                
                try {
//                    //REST call to AUTH service
//                    template.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
//                    jwtUtil.validateToken(authHeader);
                	
                	
                	return  WebClient.builder()
            		        .baseUrl("http://192.168.1.193:4444")
            		      //  .defaultCookie("cookieKey", "cookieValue")
            		        .build()
                            .get()
                            .uri(uriBuilder -> uriBuilder.path("/api/token/validateToken/{token}").build(authHeader))
                            .retrieve()
                            .bodyToMono(Boolean.class) // Expecting boolean response
                            .flatMap(validToken -> {
                                if (validToken) {
                                    // Token is valid, proceed with the request
                                    return chain.filter(exchange);
                                } else {
                                    // Token is invalid, return an error response
                                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                                    return exchange.getResponse().setComplete();
                                }
                            });
                	

                } catch (Exception e) {
                    System.out.println("invalid access...!");
                    throw new RuntimeException("un authorized access to application");
                }
            }
            return chain.filter(exchange);
        });
    }

    public static class Config {

    }
}
