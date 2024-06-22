package com.chandana.helloworld.controller;

import io.swagger.v3.oas.annotations.media.Schema;

public class GreetingResponse {

    @Schema(description = "The example response message")
    private String message;

    public GreetingResponse(String message) {
        this.message = message;
    }

    // Getters and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
