package org.it.svil.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;



class Animale {
    public void emettereSuono() {
        System.out.println("L'animale emette un suono");
    }
}
class Cane extends Animale {
    @Override
    public void emettereSuono() {
        System.out.println("Il cane abbaia");
    }
}
class Gatto extends Animale {
    @Override
    public void emettereSuono() {
        System.out.println("Il gatto miagola");
    }
}
public class PolimorfismoAnimale {
    public static void main(String[] args) {
        Animale animale1 = new Cane();
        Animale animale2 = new Gatto();

        animale1.emettereSuono();
        animale2.emettereSuono();

        try {
            FileReader file = new FileReader("file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        }

        int[] array = new int[5];
        System.out.println(array[6]);


        List<String> frutti = new ArrayList<>();
        frutti.add("Mela");
        frutti.add("Banana");
        frutti.add("Ananas");

        Set<String> frutta = new HashSet<>();
        frutta.add("Mela");
        frutta.add("Banana");
        frutta.add("Ananas");
        frutta.add("Banana");

        Map<String, String> rubrica = new HashMap<>();
        rubrica.put("1234567890", "Alice");
        rubrica.put("9876543210", "Bob");
        rubrica.put("5555555555", "Charlie");
    }
}


