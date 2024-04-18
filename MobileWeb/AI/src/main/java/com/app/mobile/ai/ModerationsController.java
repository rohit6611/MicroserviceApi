package com.app.mobile.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.reactiveclown.openaiwebfluxclient.client.moderations.*;
import reactor.core.publisher.Mono;

@RestController

public class ModerationsController {

	
	private final ModerationsExampleService moderationsExampleService;

    @Autowired
    public ModerationsController(ModerationsExampleService moderationsExampleService) {
        this.moderationsExampleService = moderationsExampleService;
    }

    @PostMapping("/create-moderation")
    public Mono<CreateModerationResponse> createModeration() {
        return moderationsExampleService.createModeration()
                .doOnNext(response -> {
                    System.out.println("Received response: " + response);
                    // Log the response or perform additional actions if needed
                })
                .doOnError(error -> {
                    System.err.println("Error occurred: " + error.getMessage());
                    // Log the error or handle it appropriately
                });
    }
	
}
