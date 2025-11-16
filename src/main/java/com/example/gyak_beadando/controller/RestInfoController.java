package com.example.gyak_beadando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestInfoController {

    @GetMapping("/rest-api")
    public String restApiInfo() {
        return "rest_api";
    }
}