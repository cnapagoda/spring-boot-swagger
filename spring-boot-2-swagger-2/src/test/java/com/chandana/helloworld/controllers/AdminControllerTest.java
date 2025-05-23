package com.chandana.helloworld.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAdminMessage() throws Exception {
        String adminName = "AdminUser";
        String expectedMessage = "Hello admin " + adminName;

        mockMvc.perform(get("/admin/hello/{name}", adminName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.player", is(adminName)))
                .andExpect(jsonPath("$.message", is(expectedMessage)));
    }

    @Test
    public void testAdminMessageWithDifferentName() throws Exception {
        String adminName = "SuperAdmin";
        String expectedMessage = "Hello admin " + adminName;

        mockMvc.perform(get("/admin/hello/{name}", adminName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.player", is(adminName)))
                .andExpect(jsonPath("$.message", is(expectedMessage)));
    }
}
