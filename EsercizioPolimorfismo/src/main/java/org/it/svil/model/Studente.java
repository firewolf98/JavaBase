package org.it.svil.model;

public class Studente {
    private String nome, cognome;
    private int isee, annoCorso;

    public Studente(String nome, String cognome, int isee, int annoCorso) {
        this.nome = nome;
        this.cognome = cognome;
        this.isee = isee;
        this.annoCorso = annoCorso;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getIsee() {
        return isee;
    }

    public int getAnnoCorso() {
        return annoCorso;
    }

    public double calcolaTasse(Studente studente) {
        double tasse = 0, incremento;
        int anniFuoriCorso, maxAnniFuoriCorso;
        if(studente instanceof Triennale) {
            maxAnniFuoriCorso= 3;
            anniFuoriCorso = Math.max(getAnnoCorso() - maxAnniFuoriCorso, 0);
            incremento = 0.10;
        } else {
            maxAnniFuoriCorso = 2;
            anniFuoriCorso = Math.max(getAnnoCorso() - maxAnniFuoriCorso, 0);
            incremento = 0.15;
        }

        if (getIsee() < 10000) {
            tasse = 500;
        } else if (getIsee() < 30000) {
            tasse = 700;
        } else {
            tasse = 1200;
        }

        if (anniFuoriCorso > 0) {
            tasse += tasse * incremento * Math.min(anniFuoriCorso, maxAnniFuoriCorso);
        }

        return tasse;
    }
}
