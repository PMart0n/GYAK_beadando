package com.example.gyak_beadando.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "eloadas")
public class Eloadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Kapcsolat Film-mel (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "filmid")
    private Film film;

    // Kapcsolat a Mozi (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "moziid")
    private Mozi mozi;

    private String datum;
    private Integer nezoszam;
    private Integer bevetel;

    public Eloadas() {}

    public Eloadas(Film film, Mozi mozi, String datum, Integer nezoszam, Integer bevetel) {
        this.film = film;
        this.mozi = mozi;
        this.datum = datum;
        this.nezoszam = nezoszam;
        this.bevetel = bevetel;
    }

    // Getter Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Film getFilm() { return film; }
    public void setFilm(Film film) { this.film = film; }
    public Mozi getMozi() { return mozi; }
    public void setMozi(Mozi mozi) { this.mozi = mozi; }
    public String getDatum() { return datum; }
    public void setDatum(String datum) { this.datum = datum; }
    public Integer getNezoszam() { return nezoszam; }
    public void setNezoszam(Integer nezoszam) { this.nezoszam = nezoszam; }
    public Integer getBevetel() { return bevetel; }
    public void setBevetel(Integer bevetel) { this.bevetel = bevetel; }
}