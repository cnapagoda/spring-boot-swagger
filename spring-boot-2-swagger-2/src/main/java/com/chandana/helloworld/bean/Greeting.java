package com.chandana.helloworld.bean;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents a greeting message.
 */
public class Greeting {

    /**
     * The name of the user provided for the greeting.
     */
    @Schema(description = "Provided user name", requiredMode = Schema.RequiredMode.REQUIRED)
    private String player;

    /**
     * The system-generated greeting message.
     */
    @Schema(description = "The system generated greeting message" , readOnly = true)
    private String message;

    /**
     * Constructs a new Greeting object.
     * @param player The name of the user.
     * @param message The greeting message.
     */
    public Greeting(String player, String message) {
        this.player = player;
        this.message = message;
    }

    /**
     * Gets the player's name.
     * @return The player's name.
     */
    public String getPlayer() {
        return player;
    }

    /**
     * Sets the player's name.
     * @param player The player's name.
     */
    public void setPlayer(String player) {
        this.player = player;
    }

    /**
     * Gets the greeting message.
     * @return The greeting message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the greeting message.
     * @param message The greeting message.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
