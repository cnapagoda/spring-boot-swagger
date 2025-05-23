package com.chandana.helloworld.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GreetingController.class)
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateAndGetExample() throws Exception {
        GreetingRequest request = new GreetingRequest();
        request.setMessage("Test Greeting");

        // Create
        String responseString = mockMvc.perform(post("/api/greetings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message", is("Created Test Greeting")))
                .andExpect(jsonPath("$.id").exists())
                .andReturn().getResponse().getContentAsString();

        GreetingResponse createdGreeting = objectMapper.readValue(responseString, GreetingResponse.class);
        int createdId = createdGreeting.getId();

        // Get
        mockMvc.perform(get("/api/greetings/{id}", createdId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(createdId)))
                .andExpect(jsonPath("$.message", is("Created Test Greeting")));
    }

    @Test
    public void testGetExampleNotFound() throws Exception {
        mockMvc.perform(get("/api/greetings/{id}", 999))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateExample() throws Exception {
        // First, create a greeting to update
        GreetingRequest createRequest = new GreetingRequest();
        createRequest.setMessage("Initial Greeting");
        String responseString = mockMvc.perform(post("/api/greetings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createRequest)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        
        GreetingResponse createdGreeting = objectMapper.readValue(responseString, GreetingResponse.class);
        int createdId = createdGreeting.getId();

        // Now, update it
        GreetingRequest updateRequest = new GreetingRequest();
        updateRequest.setMessage("Updated Greeting");

        mockMvc.perform(put("/api/greetings/{id}", createdId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(createdId)))
                .andExpect(jsonPath("$.message", is("Updated Updated Greeting")));

        // Verify update
        mockMvc.perform(get("/api/greetings/{id}", createdId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(createdId)))
                .andExpect(jsonPath("$.message", is("Updated Updated Greeting")));
    }

    @Test
    public void testUpdateExampleNotFound() throws Exception {
        GreetingRequest updateRequest = new GreetingRequest();
        updateRequest.setMessage("Updated Greeting");

        mockMvc.perform(put("/api/greetings/{id}", 999)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteExample() throws Exception {
        // First, create a greeting to delete
        GreetingRequest createRequest = new GreetingRequest();
        createRequest.setMessage("To Be Deleted");
        String responseString = mockMvc.perform(post("/api/greetings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createRequest)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        GreetingResponse createdGreeting = objectMapper.readValue(responseString, GreetingResponse.class);
        int createdId = createdGreeting.getId();

        // Delete it
        mockMvc.perform(delete("/api/greetings/{id}", createdId))
                .andExpect(status().isNoContent());

        // Verify it's gone
        mockMvc.perform(get("/api/greetings/{id}", createdId))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteExampleNotFound() throws Exception {
        mockMvc.perform(delete("/api/greetings/{id}", 999))
                .andExpect(status().isNotFound());
    }
}
