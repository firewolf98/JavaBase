package org.it.svil.test;

public class Main {
    public static void main(String[] args) {
        GenericMatematica<Number> gen = new GenericMatematica<>(10.5f);
        gen.riconosciTipo();

        GenericMatematica<Number> gen1 = new GenericMatematica<>(10.5);
        gen1.riconosciTipo();

        byte bt = 10;
        GenericMatematica<Number> gen2 = new GenericMatematica<>(bt);
        gen2.riconosciTipo();
    }
}