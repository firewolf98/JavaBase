package org.it.svil.test;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[6];

        System.out.println("Inserisci un numero");
        int a = scanner.nextInt();
        System.out.println("Inserisci un altro numero");
        int b = scanner.nextInt();

        Random random=new Random();
        int value = random.nextInt((10 - 1) + 1) +1;
        int divisione = a / b;

        try {
            array[value] = divisione;
            System.out.println("Il valore  " + divisione + " è stato inserito nella posizione--> " + value + " dell'array");
        } catch (ArithmeticException e) {
            System.out.println("Errore! Divisione per zero!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Valore " + divisione + " lecito ma problema con l'indice");
        } finally {
            scanner.close();
        }
    }
}