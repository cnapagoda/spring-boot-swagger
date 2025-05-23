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

/**
 * Controller for managing Greetings.
 * Provides CRUD operations for greeting resources.
 */
@RestController
@RequestMapping("/api/greetings")
@Tag(name = "greetings") // Description is inherited from @OpenAPIDefinition
public class GreetingController {

    private final Map<Integer, GreetingResponse> examples = new HashMap<>();

    /**
     * Retrieves a greeting by its ID.
     * @param id The ID of the greeting to retrieve.
     * @return ResponseEntity containing the GreetingResponse if found, or HttpStatus.NOT_FOUND if not.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get example by ID", description = "Retrieve an example resource by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Greeting not found")
    })
    public ResponseEntity<GreetingResponse> getExample(
            @Parameter(description = "ID of the greeting to retrieve", required = true) @PathVariable int id) {
        GreetingResponse example = examples.get(id);
        if (example == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(example, HttpStatus.OK);
    }

    /**
     * Creates a new greeting.
     * @param request The GreetingRequest containing the details for the new greeting.
     * @return ResponseEntity containing the created GreetingResponse and HttpStatus.CREATED.
     */
    @PostMapping
    @Operation(summary = "Create a new example", description = "Create a new example resource")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Greeting created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<GreetingResponse> createExample(
            @Parameter(description = "Greeting request object") @RequestBody GreetingRequest request) {
        int id = examples.size() + 1;
        GreetingResponse example = new GreetingResponse(id, "Created " + request.getMessage());
        examples.put(id, example);
        return new ResponseEntity<>(example, HttpStatus.CREATED);
    }

    /**
     * Updates an existing greeting by its ID.
     * @param id The ID of the greeting to update.
     * @param request The GreetingRequest containing the updated details.
     * @return ResponseEntity containing the updated GreetingResponse if found, or HttpStatus.NOT_FOUND if not.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update an example by ID", description = "Update an existing example resource by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Greeting updated"),
            @ApiResponse(responseCode = "404", description = "Greeting not found")
    })
    public ResponseEntity<GreetingResponse> updateExample(
            @Parameter(description = "ID of the greeting to update", required = true) @PathVariable int id,
            @Parameter(description = "Greeting request object with updated details") @RequestBody GreetingRequest request) {
        GreetingResponse example = examples.get(id);
        if (example == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        example.setMessage("Updated " + request.getMessage());
        return new ResponseEntity<>(example, HttpStatus.OK);
    }

    /**
     * Deletes a greeting by its ID.
     * @param id The ID of the greeting to delete.
     * @return ResponseEntity with HttpStatus.NO_CONTENT if successful, or HttpStatus.NOT_FOUND if not.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an example by ID", description = "Delete an example resource by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Greeting deleted"),
            @ApiResponse(responseCode = "404", description = "Greeting not found")
    })
    public ResponseEntity<Void> deleteExample(
            @Parameter(description = "ID of the greeting to delete", required = true) @PathVariable int id) {
        if (!examples.containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        examples.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}