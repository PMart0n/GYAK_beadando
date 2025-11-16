package com.example.gyak_beadando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiagramController {

    @GetMapping("/diagram")
    public String diagramOldal() {
        return "diagram";
    }
}