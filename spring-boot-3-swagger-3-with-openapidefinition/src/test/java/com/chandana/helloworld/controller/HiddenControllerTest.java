package com.chandana.helloworld.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(HiddenController.class)
public class HiddenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHealthCheck() throws Exception {
        mockMvc.perform(get("/api/hidden/healthcheck"))
                .andExpect(status().isOk())
                .andExpect(content().string("Running"));
    }
}
