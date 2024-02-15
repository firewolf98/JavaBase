package org.it.svil.model;

public class Film {
    private String titolo;
    private int year;

    public Film(String titolo, int year) {
        this.titolo = titolo;
        this.year = year;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titolo='" + titolo + '\'' +
                ", annoProduzione=" + year +
                '}';
    }
}
