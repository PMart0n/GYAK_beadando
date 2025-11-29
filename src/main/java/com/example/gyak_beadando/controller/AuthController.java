package com.example.gyak_beadando.controller;

import com.example.gyak_beadando.entity.User;
import com.example.gyak_beadando.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/do-register")
    public String doRegister(@RequestParam String username,
                             @RequestParam String password,
                             Model model) {

        // Felhasználónév foglaltság ellenőrzése
        User existing = userRepository.findByUsername(username);
        if (existing != null) {
            model.addAttribute("error", "A felhasználónév már foglalt!");
            return "register";
        }

        // Jelszó hash-elése
        String encodedPassword = passwordEncoder.encode(password);

        // Mentés ROLE_USER szerepkörrel
        User user = new User(username, encodedPassword, "ROLE_USER");
        userRepository.save(user);

        model.addAttribute("success", "Sikeres regisztráció! Most már be tudsz lépni.");
        return "register";
    }
}