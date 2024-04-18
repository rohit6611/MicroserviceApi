package com.app.mobile.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component

public class CustomOncePerRequestFilter implements WebFilter {
	
	 //   WebClient.Builder webClientBuilder;

	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

//		String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
//		System.out.println("Custom filter is processing the request "+token);
//
//        return chain.filter(exchange);

//		// Retrieve the token from the request headers
	String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
	System.out.println("token: " + token);
//		// Perform token validation (you need to implement this)
//		boolean isValidToken = validateToken(token);
//
//		// If token is valid, set authentication in security context
//		if (isValidToken) {
//			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("user", null,
//					AuthorityUtils.createAuthorityList("ROLE_USER")));
//			return chain.filter(exchange);
//		} else {
//			// If token is invalid, return unauthorized response
//			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//			return exchange.getResponse().setComplete();
//		}
//	return null;

//        // Proceed with the filter chain
//        return chain.filter(exchange)
//                .then(Mono.defer(() -> {
//                    // Get the response status code
//                    HttpStatus statusCode = exchange.getResponse().getStatusCode();
//                    System.out.println("Response Status Code: " + statusCode);
//
//                    // Get the response body as a Flux<DataBuffer>
//                    DataBufferFactory responseBody = exchange.getResponse().bufferFactory();
//
//                    
//                    responseBody.                    
//                    
//                    // Convert the response body to a String and print it
//                    return responseBody.map(buffer -> {
//                        byte[] bytes = new byte[buffer.readableByteCount()];
//                        buffer.read(bytes);
//                        DataBufferUtils.release(buffer);
//                        return new String(bytes, StandardCharsets.UTF_8);
//                    }).collectList().doOnNext(bodyChunks -> {
//                        StringBuilder responseBodyBuilder = new StringBuilder();
//                        bodyChunks.forEach(responseBodyBuilder::append);
//                        String responseBodyString = responseBodyBuilder.toString();
//                        System.out.println("Response Body: " + responseBodyString);
//                    }).then();
//                }));
		
		
		return  WebClient.builder()
		        .baseUrl("http://127.0.0.1:4444")
		      //  .defaultCookie("cookieKey", "cookieValue")
		        .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path("/api/token/validateToken/{token}").build(token))
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
		

	}

	// Method to validate token (example implementation)
	private boolean validateToken(String token) {
return true;
//		
//		 return webClientBuilder.baseUrl(TOKEN_VALIDATION_URL)
//	                .build()
//	                .get()
//	                .uri(uriBuilder -> uriBuilder.queryParam("token", token).build())
//	                .retrieve()
//	                .bodyToMono(Boolean.class) // Expecting boolean response
//	                .flatMap(validToken -> {
//	                    if (validToken) {
//	                        // Token is valid, proceed with the request
//	                        return chain.filter(exchange);
//	                    } else {
//	                        // Token is invalid, return an error response
//	                        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//	                        return exchange.getResponse().setComplete();
//	                    }
//	                });
//		
//		
//		Boolean tokenBoolean = WebClient.builder()
//		        .baseUrl("http://192.168.1.193:4444")
//		      //  .defaultCookie("cookieKey", "cookieValue")
//		        .build()
//		        .get()
//		        .uri(uriBuilder -> uriBuilder.path("/api/token/validateToken/{token}").build(token))
//		        .retrieve()
//		        .bodyToMono(Boolean.class)
//		        .subscribeOn(Schedulers.boundedElastic()) // Offload blocking operation to separate thread pool
//		        .block();
//
//		return tokenBoolean;
//
//		// Add your token validation logic here
//		// For example, you could use JWT validation or check against a database
//		// return token != null && token.startsWith("Bearer");
	}

	private Mono<Void> decryptResponseData(ServerWebExchange exchange, WebFilterChain chain) {
		return null;
//
//    	 Flux<DataBuffer> responseBody = exchange.getResponse().bufferFactory().allocateBuffer().writeWith(
//                 Flux.just(exchange.getResponse().bufferFactory().wrap("Your response body content".getBytes(StandardCharsets.UTF_8)))
//         );
//
//         // Process or log the response body Flux<DataBuffer> as needed
//         responseBody.subscribe(dataBuffer -> {
//             byte[] bytes = new byte[dataBuffer.readableByteCount()];
//             dataBuffer.read(bytes);
//             String responseBodyString = new String(bytes, StandardCharsets.UTF_8);
//             System.out.println("Response Body: " + responseBodyString);
//             // You can process the response body here
//         });
//
////        return exchange.getResponse().writeWith(Mono.just(exchange.getResponse().bufferFactory().wrap()));
////
////    	
////    	return exchange.mutate().response(ServerHttpResponse)
////
////
//    	exchange.getResponse()
//    	
//    	exchange.getRequest().getBody().collect(null)
//    	
//        return exchange.getResponse().
//        		getBody()
//                .collectList()
//                .flatMap(dataBuffers -> {
//                    // Concatenate the data buffers into a single byte array
//                    byte[] responseData = concatenateDataBuffers(dataBuffers);
//
//                    // Decrypt response data
//                    byte[] decryptedData = decrypt(responseData);
//
//                    // Create a new data buffer with the decrypted data
//                    DataBuffer decryptedBuffer = exchange.getResponse().bufferFactory().wrap(decryptedData);
//
//                    // Write the decrypted data back to the response
//                    return exchange.getResponse().writeWith(Flux.just(decryptedBuffer));
//                });
	}

	// Dummy methods for encryption and decryption
	private byte[] encrypt(byte[] data) {
		// Implement encryption logic
		// This is a placeholder, replace it with your encryption logic
		return data;
	}

	private byte[] decrypt(byte[] data) {
		// Implement decryption logic
		// This is a placeholder, replace it with your decryption logic
		return data;
	}

}
