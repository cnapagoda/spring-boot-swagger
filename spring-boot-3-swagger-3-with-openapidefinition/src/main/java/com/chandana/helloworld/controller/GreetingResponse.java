package com.chandana.helloworld.controller;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents a response object for a greeting.
 */
public class GreetingResponse {

    /**
     * The ID of the greeting.
     */
    @Schema(description = "The ID of the greeting", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    /**
     * The message content of the greeting response.
     */
    @Schema(description = "The example response message")
    private String message;

    /**
     * Constructs a new GreetingResponse.
     * @param message The message content.
     */
    public GreetingResponse(String message) {
        this.message = message;
    }

    /**
     * Constructs a new GreetingResponse with an ID.
     * @param id The ID of the greeting.
     * @param message The message content.
     */
    public GreetingResponse(int id, String message) {
        this.id = id;
        this.message = message;
    }


    /**
     * Gets the ID of the greeting.
     * @return The ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the greeting.
     * @param id The ID.
     */
    public void setId(int id) {
        this.id = id;
    }

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
