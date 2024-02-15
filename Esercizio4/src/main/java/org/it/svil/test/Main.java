package org.it.svil.test;

public class Main {
    public static void main(String[] args) {
        int a = 5, b = 3;
        double r1 = (double) a / b;

        char c = 'a';
        short s = 5000;
        int r2 = c * s;

        int i = 6;
        float f = 3.14F;
        float r3 = i + f;

        double r4 = r1 - r2 - r3;

        System.out.println("Risultato parziale 1 (divisione): " + r1);
        System.out.println("Risultato parziale 2 (moltiplicazione): " + r2);
        System.out.println("Risultato parziale 3 (somma): " + r3);
        System.out.println("Risultato finale (sottrazione): " + r4);
    }
}
