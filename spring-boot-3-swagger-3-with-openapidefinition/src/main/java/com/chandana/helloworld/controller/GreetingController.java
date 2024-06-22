package com.chandana.helloworld.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/greetings")
@Tag(name = "greetings", description = "These are greetings API operations")
public class GreetingController {

    private final Map<Integer, GreetingResponse> examples = new HashMap<>();

    @GetMapping("/{id}")
    @Operation(summary = "Get example by ID", description = "Retrieve an example resource by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Greeting not found")
    })
    public ResponseEntity<GreetingResponse> getExample(
            @PathVariable @Parameter(allowEmptyValue = false, required = true) int id) {
        GreetingResponse example = examples.get(id);
        if (example == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(example, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create a new example", description = "Create a new example resource")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Greeting created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<GreetingResponse> createExample(@RequestBody GreetingRequest request) {
        GreetingResponse example = new GreetingResponse("Created " + request.getMessage());
        int id = examples.size() + 1;
        examples.put(id, example);
        return new ResponseEntity<>(example, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an example by ID", description = "Update an existing example resource by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Greeting updated"),
            @ApiResponse(responseCode = "404", description = "Greeting not found")
    })
    public ResponseEntity<GreetingResponse> updateExample(
            @PathVariable @Parameter(allowEmptyValue = false, required = true) int id,
            @RequestBody GreetingRequest request) {
        GreetingResponse example = examples.get(id);
        if (example == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        example.setMessage("Updated " + request.getMessage());
        return new ResponseEntity<>(example, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an example by ID", description = "Delete an example resource by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Greeting deleted"),
            @ApiResponse(responseCode = "404", description = "Greeting not found")
    })
    public ResponseEntity<Void> deleteExample(
            @PathVariable @Parameter(allowEmptyValue = false, required = true) int id) {
        if (!examples.containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        examples.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}