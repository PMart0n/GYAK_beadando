package com.example.gyak_beadando.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Kikapcsoljuk az űrlapvédelmet fejlesztés alatt
                .authorizeHttpRequests((requests) -> requests
                        // Itt soroljuk fel, mit láthat BÁRKI (permitAll):
                        .requestMatchers(
                                "/",
                                "/home",
                                "/adatbazis",
                                "/kapcsolat",
                                "/diagram",
                                "/rest-api",
                                "/uzenetek",
                                "/film-kezeles/**",
                                "/admin",
                                "/api/**",
                                "/assets/**",
                                "/images/**",
                                "/login",
                                "/regisztral"
                        ).permitAll()
                        .anyRequest().authenticated() // Minden más védett marad
                )
                .formLogin((form) -> form.permitAll())
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
}