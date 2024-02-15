package org.it.svil.test;

import org.it.svil.model.Alimento;

import java.util.ArrayList;
import java.util.List;

public class Elenco {
    public static void main(String[] args) {
        List<Alimento> alimenti = new ArrayList<>();
        alimenti.add(new Alimento("Pasta", 0.50));
        alimenti.add(new Alimento("Latte", 1.0));
        for(Alimento alimento: alimenti)
            System.out.println(alimento);
    }
}