package com.app.mobile.ai;

import org.springframework.stereotype.Service;

import io.github.reactiveclown.openaiwebfluxclient.client.images.*;
import reactor.core.publisher.Mono;

@Service
public class ImageExampleService {

    private final ImagesService service;

    public ImageExampleService(ImagesService service) {
        this.service = service;
    }

    //Non-blocking
    public Mono<CreateImageResponse> createImage() {
        return service.createImage(
                CreateImageRequest
                        .builder("Generate a image for firebird")
                        .build());
    }

    //Blocking
    public Mono<CreateImageVariationResponse> createImageVariation() {
        return service.createImageVariation(
                CreateImageVariationRequest
                        .builder("src/main/resources/exampleImage.png")
                        .size("512x512")
                        .build());
    }

    //Blocking
    public Mono<CreateImageEditResponse> createImageEdit() {
        return service.createImageEdit(
                CreateImageEditRequest
                        .builder("src/main/resources/exampleImage.png", "Generate a green fields")
                        .mask("src/main/resources/exampleMask.png")
                        .build());
    }
}
