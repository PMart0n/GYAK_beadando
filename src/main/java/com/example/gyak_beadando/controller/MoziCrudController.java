//Nem kell lehet majd törölni
package com.example.gyak_beadando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mozi-kezeles") // Minden itteni URL ezzel kezdődik majd
public class MoziCrudController {

    // Űrlap megjelenítése új mozihoz
    @GetMapping
    public String szerkesztoUrlap() {
        return "mozi_edit";
    }
}