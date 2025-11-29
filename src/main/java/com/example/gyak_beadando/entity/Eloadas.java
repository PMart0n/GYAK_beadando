package com.example.gyak_beadando.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "eloadas")
public class Eloadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer bevetel;

    @Column(name = "datum")
    private String datum;  // SQL szerint VARCHAR

    private Integer nezoszam;

    @ManyToOne
    @JoinColumn(name = "filmid")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "moziid")
    private Mozi mozi;

    public Eloadas() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getBevetel() { return bevetel; }
    public void setBevetel(Integer bevetel) { this.bevetel = bevetel; }

    public String getDatum() { return datum; }
    public void setDatum(String datum) { this.datum = datum; }

    public Integer getNezoszam() { return nezoszam; }
    public void setNezoszam(Integer nezoszam) { this.nezoszam = nezoszam; }

    public Film getFilm() { return film; }
    public void setFilm(Film film) { this.film = film; }

    public Mozi getMozi() { return mozi; }
    public void setMozi(Mozi mozi) { this.mozi = mozi; }
}