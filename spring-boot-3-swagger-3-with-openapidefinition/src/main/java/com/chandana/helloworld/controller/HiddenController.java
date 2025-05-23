package com.chandana.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * A controller for endpoints that should be hidden from the OpenAPI documentation.
 * Useful for health checks or other internal API endpoints.
 */
@RestController
@RequestMapping("/api/hidden")
@Hidden
public class HiddenController {

    /**
     * A simple health check endpoint.
     * @return A string indicating the service is running.
     */
    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "Running";
    }

}
