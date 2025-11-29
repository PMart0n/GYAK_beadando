package com.example.gyak_beadando.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "mozi")
public class Mozi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nev;
    private String varos;
    private Integer ferohely;

    @JsonIgnore
    @OneToMany(mappedBy = "mozi", cascade = CascadeType.ALL)
    private List<Eloadas> eloadasok;

    public Mozi() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNev() { return nev; }
    public void setNev(String nev) { this.nev = nev; }

    public String getVaros() { return varos; }
    public void setVaros(String varos) { this.varos = varos; }

    public Integer getFerohely() { return ferohely; }
    public void setFerohely(Integer ferohely) { this.ferohely = ferohely; }

    public List<Eloadas> getEloadasok() { return eloadasok; }
    public void setEloadasok(List<Eloadas> eloadasok) { this.eloadasok = eloadasok; }
}