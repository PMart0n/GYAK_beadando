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

    public Uzenet() {}

    public Uzenet(String kuldoNeve, String email, String szoveg) {
        this.kuldoNeve = kuldoNeve;
        this.email = email;
        this.szoveg = szoveg;
    }

    public Long getId() {
        return id;
    }

    public String getKuldoNeve() {
        return kuldoNeve;
    }

    public void setKuldoNeve(String kuldoNeve) {
        this.kuldoNeve = kuldoNeve;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSzoveg() {
        return szoveg;
    }

    public void setSzoveg(String szoveg) {
        this.szoveg = szoveg;
    }
}