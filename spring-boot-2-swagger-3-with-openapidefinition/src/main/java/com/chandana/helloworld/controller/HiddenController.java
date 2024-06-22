package com.chandana.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/hidden")
@Hidden
public class HiddenController {

    @GetMapping("/healthcheck")
    public String getMethodName() {
        return new String("Running");
    }

}
