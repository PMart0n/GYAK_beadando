package com.example.gyak_beadando.controller;

import com.example.gyak_beadando.entity.User;
import com.example.gyak_beadando.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    //
    @GetMapping("/register")
    public String registerPage(Model model) {
        return "register";
    }

    //
    @PostMapping("/do-register")
    public String doRegister(@RequestParam String username,
                             @RequestParam String password,
                             Model model) {

        if (userRepository.findByUsername(username) != null) {
            model.addAttribute("error", "A felhasználónév már foglalt!");
            return "register";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("ROLE_USER");

        userRepository.save(user);

        // Sikeres regisztráció után átirányítunk a loginra
        return "redirect:/login?success";
    }
}