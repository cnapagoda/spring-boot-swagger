package com.chandana.helloworld.controllers;

import com.chandana.helloworld.bean.Greeting;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for user-facing operations.
 * Provides REST endpoints for general user interactions.
 */
@RestController
@RequestMapping("/api")
@Tag(name = "User API", description = "Rest API for user operations")
public class HelloWorldController {

    /**
     * Greets a non-admin user.
     * This endpoint returns a personalized greeting message for a non-admin user.
     *
     * @param name The name of the user.
     * @return A Greeting object containing the personalized message.
     */
    @GetMapping(value = "/hello/{name}", produces = "application/json")
    @Operation(summary = "Display greeting message to non-admin user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "The resource not found")
    }
    )
    public Greeting message(@Parameter(description = "User's name") @PathVariable String name) {
        Greeting msg = new Greeting(name, "Hello " + name);
        return msg;
    }

}
