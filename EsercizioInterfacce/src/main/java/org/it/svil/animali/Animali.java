package org.it.svil.animali;

public abstract class Animali {
    private String specie, nome;
    private boolean haMangiato;

    public Animali() {
        this.specie = "";
        this.nome = "";
        this.haMangiato = false;
    }

    public Animali(String specie, String nome) {
        this.specie = specie;
        this.nome = nome;
        this.haMangiato = false;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isHaMangiato() {
        return haMangiato;
    }

    public void setHaMangiato(boolean haMangiato) {
        this.haMangiato = haMangiato;
    }

    @Override
    public String toString() {
        return "Animali{" +
                "specie='" + specie + '\'' +
                ", nome='" + nome + '\'' +
                ", haMangiato=" + haMangiato +
                '}';
    }

    public abstract void mangia();
}
