package com.example.gyak_beadando.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "uzenetek")
public class Uzenet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kuldoNeve;
    private String email;
    private String szoveg;

    // Getterek és Setterek ide
}