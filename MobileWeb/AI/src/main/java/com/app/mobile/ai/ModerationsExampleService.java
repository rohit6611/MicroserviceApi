package com.app.mobile.ai;

import org.springframework.stereotype.Service;

import io.github.reactiveclown.openaiwebfluxclient.client.moderations.CreateModerationRequest;
import io.github.reactiveclown.openaiwebfluxclient.client.moderations.CreateModerationResponse;
import io.github.reactiveclown.openaiwebfluxclient.client.moderations.ModerationsService;
import reactor.core.publisher.Mono;

@Service
public class ModerationsExampleService {

    private final ModerationsService service;

    public ModerationsExampleService(ModerationsService service) {
        this.service = service;
    }

    public Mono<CreateModerationResponse> createModeration() {
        return service.createModeration(
                CreateModerationRequest.builder("I want to kill them.").build());
    }
}