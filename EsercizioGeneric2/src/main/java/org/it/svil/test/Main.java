package org.it.svil.test;

public class Main {
    public static void main(String[] args) {
        Integer arrayinteri[] = {1,2,3,4,5};
        printGenericArray(arrayinteri);

        String arraystringhe[] = {"Luca","Mirko","Mario"};
        printGenericArray(arraystringhe);
    }

    private static <T> void printGenericArray(T[] array) {
        for (T elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}
