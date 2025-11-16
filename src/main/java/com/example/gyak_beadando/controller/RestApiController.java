package com.example.gyak_beadando.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.ArrayList;

// Fontos: @RestController, nem sima @Controller!
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/teszt")
    public String tesztVegpont() {
        return "Működik a REST API!";
    }
}