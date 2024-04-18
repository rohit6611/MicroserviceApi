package com.app.mobile.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.reactiveclown.openaiwebfluxclient.client.completions.CreateCompletionRequest;
import io.github.reactiveclown.openaiwebfluxclient.client.completions.CreateCompletionResponse;
import reactor.core.publisher.Mono;

@RestController
public class CompletionsController {

    private final CompletionsServiceExample completionsServiceExample;

    @Autowired
    public CompletionsController(CompletionsServiceExample completionsServiceExample) {
        this.completionsServiceExample = completionsServiceExample;
    }

    @PostMapping("/create-completion")
    public Mono<CreateCompletionResponse> createCompletion() {

        Mono<CreateCompletionResponse> completionResponseMono = completionsServiceExample.createCompletion();

        completionResponseMono.subscribe(
                response -> System.out.println("Received response: " + response),
                error -> System.err.println("Error occurred: " + error.getMessage())
        );

        return completionResponseMono;
    }
}

