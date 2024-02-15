package org.it.svil.test;

public class Main {
    public static void main(String[] args) {
        ClasseGenerica<Integer, String> c1 = new ClasseGenerica<>(3, "Luca");
        ClasseGenerica<String, Integer> c2 = new ClasseGenerica<>("Ciao", 4);
        ClasseGenerica<Boolean, Boolean> c3 = new ClasseGenerica<>(true,false);
        ClasseGenerica<Integer, Double> c4 = new ClasseGenerica<>(3, 3.5);
        ClasseGenerica<Integer, Integer> c5 = new ClasseGenerica<>(3,4);

        c1.metodoGenerico();
        c2.metodoGenerico();
        c3.metodoGenerico();
        c4.metodoGenerico();
        c5.metodoGenerico();
    }
}