package com.chandana.helloworld.controllers;

import com.chandana.helloworld.bean.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMessage() throws Exception {
        String userName = "TestUser";
        String expectedMessage = "Hello " + userName;

        mockMvc.perform(get("/api/hello/{name}", userName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.player", is(userName)))
                .andExpect(jsonPath("$.message", is(expectedMessage)));
    }

    @Test
    public void testMessageWithDifferentName() throws Exception {
        String userName = "AnotherUser";
        String expectedMessage = "Hello " + userName;

        mockMvc.perform(get("/api/hello/{name}", userName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.player", is(userName)))
                .andExpect(jsonPath("$.message", is(expectedMessage)));
    }
}
