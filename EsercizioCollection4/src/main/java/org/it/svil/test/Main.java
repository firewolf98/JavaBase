package org.it.svil.test;

import org.it.svil.model.Rubrica;

public class Main {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();
        rubrica.aggiungiContatto("Luca","Esposito","098765423");
        System.out.println(rubrica);
        rubrica.aggiungiContatto("Mirko","Viale","3456789345");
        System.out.println(rubrica);
        System.out.println(rubrica.cerca("Luca","Esposito"));
        rubrica.rimuoviContatto("Mirko","Viale");
        System.out.println(rubrica);
    }
}