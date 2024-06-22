package com.chandana.helloworld.controller;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The example request message")
public class GreetingRequest {

    @Schema(description = "The example message", example = "Hello, World!")
    private String message;

    // Getters and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
