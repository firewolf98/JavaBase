package org.it.svil.model;

public class Animale {
    private String specie;
    private String nome;
    private String habitat;

    public Animale(String specie, String nome, String habitat) {
        this.specie = specie;
        this.nome = nome;
        this.habitat = habitat;
    }

    public String getSpecie() { return specie; }

    public void setSpecie(String specie) { this.specie = specie; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getHabitat() { return habitat; }

    public void setHabitat(String habitat) { this.habitat = habitat; }

    public void emettiSuono() {
        System.out.println("L'animale emette un suono.");
    }
}

