package com.app.mobile.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.reactiveclown.openaiwebfluxclient.client.images.CreateImageEditResponse;
import io.github.reactiveclown.openaiwebfluxclient.client.images.CreateImageResponse;
import io.github.reactiveclown.openaiwebfluxclient.client.images.CreateImageVariationResponse;
import reactor.core.publisher.Mono;

@RestController
public class ImageController {

    private final ImageExampleService imageExampleService;

    @Autowired
    public ImageController(ImageExampleService imageExampleService) {
        this.imageExampleService = imageExampleService;
    }

    @PostMapping("/create-image")
    public Mono<CreateImageResponse> createImage() {
        return imageExampleService.createImage()
                .doOnNext(response -> {
                    System.out.println("Received response for createImage(): " + response);
                    // Log the response or perform additional actions if needed
                })
                .doOnError(error -> {
                    System.err.println("Error occurred for createImage(): " + error.getMessage());
                    // Log the error or handle it appropriately
                });
    }

    @PostMapping("/create-image-variation")
    public Mono<CreateImageVariationResponse> createImageVariation() {
        return imageExampleService.createImageVariation()
                .doOnNext(response -> {
                    System.out.println("Received response for createImageVariation(): " + response);
                    // Log the response or perform additional actions if needed
                })
                .doOnError(error -> {
                    System.err.println("Error occurred for createImageVariation(): " + error.getMessage());
                    // Log the error or handle it appropriately
                });
    }

    @PostMapping("/create-image-edit")
    public Mono<CreateImageEditResponse> createImageEdit() {
        return imageExampleService.createImageEdit()
                .doOnNext(response -> {
                    System.out.println("Received response for createImageEdit(): " + response);
                    // Log the response or perform additional actions if needed
                })
                .doOnError(error -> {
                    System.err.println("Error occurred for createImageEdit(): " + error.getMessage());
                    // Log the error or handle it appropriately
                });
    }
}

