package com.chandana.helloworld.controller;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents a request object for creating or updating a greeting.
 */
@Schema(description = "The example request message")
public class GreetingRequest {

    /**
     * The message content for the greeting.
     */
    @Schema(description = "The example message", example = "Hello, World!")
    private String message;

    /**
     * Gets the message content.
     * @return The message content.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message content.
     * @param message The message content.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
