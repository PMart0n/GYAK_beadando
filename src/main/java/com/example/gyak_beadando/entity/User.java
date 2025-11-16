package com.example.gyak_beadando.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role; // pl. "ROLE_USER", "ROLE_ADMIN"

    // Getterek, Setterek, Konstruktorok majd ide jönnek
}