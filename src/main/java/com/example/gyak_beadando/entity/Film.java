package com.example.gyak_beadando.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cim;
    private Integer ev;
    private Integer hossz;

    @JsonIgnore
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Eloadas> eloadasok;

    public Film() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCim() { return cim; }
    public void setCim(String cim) { this.cim = cim; }

    public Integer getEv() { return ev; }
    public void setEv(Integer ev) { this.ev = ev; }

    public Integer getHossz() { return hossz; }
    public void setHossz(Integer hossz) { this.hossz = hossz; }

    public List<Eloadas> getEloadasok() { return eloadasok; }
    public void setEloadasok(List<Eloadas> eloadasok) { this.eloadasok = eloadasok; }
}