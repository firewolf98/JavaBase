package org.it.svil.test;

public class GenericMatematica<T extends Number> {
    private T value;

    public GenericMatematica(T value) {
        this.value = value;
    }

    public void riconosciTipo() {
        System.out.println("E' un " + value.getClass().getSimpleName().toLowerCase());
    }
}
