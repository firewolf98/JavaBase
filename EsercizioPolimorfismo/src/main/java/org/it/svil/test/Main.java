package org.it.svil.test;

import org.it.svil.model.*;

public class Main {
    public static void main(String[] args) {
        Studente[] studenti = {
                new Triennale("Mario", "Rossi", 8000, 2),
                new Magistrale("Paolo", "Bianchi", 20000, 5),
                new Triennale("Giuseppe", "Verdi", 35000, 4),
                new Triennale("Mirko", "Viale", 35000, 5),
                new Magistrale("Luca", "Esposito", 9000, 1)
        };

        for(Studente studente: studenti) {
            System.out.println(studente.getNome() + " paga: " + studente.calcolaTasse(studente));
        }
    }
}