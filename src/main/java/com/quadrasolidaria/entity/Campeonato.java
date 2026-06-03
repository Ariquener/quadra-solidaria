package com.quadrasolidaria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "campeonato")
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_campeonato")
    private Integer idCampeonato;

    @Column(length = 100)
    private String nome;

    @Column(length = 50)
    private String categoria;

    private Integer equipes;

    public Campeonato() {
    }

    public Integer getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(Integer idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getEquipes() {
        return equipes;
    }

    public void setEquipes(Integer equipes) {
        this.equipes = equipes;
    }
}
