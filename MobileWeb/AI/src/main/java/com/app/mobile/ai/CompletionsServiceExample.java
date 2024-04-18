package com.app.mobile.ai;

import org.springframework.stereotype.Service;

import io.github.reactiveclown.openaiwebfluxclient.client.completions.CompletionsService;
import io.github.reactiveclown.openaiwebfluxclient.client.completions.CreateCompletionRequest;
import io.github.reactiveclown.openaiwebfluxclient.client.completions.CreateCompletionResponse;
import reactor.core.publisher.Mono;

@Service
public class CompletionsServiceExample {

	
	  private final CompletionsService service;

	    public CompletionsServiceExample(CompletionsService service) {
	        this.service = service;
	    }

	    public Mono<CreateCompletionResponse> createCompletion() {
	        return service.createCompletion(
	                CreateCompletionRequest
	                        .builder("gpt-3.5-turbo-instruct")
	                        .prompt("Provide a message for Birthday")
	                        .maxTokens(10)
	                        //.n(2)
	                        //.bestOf(1)
	                        .build());
	    }
	
}
