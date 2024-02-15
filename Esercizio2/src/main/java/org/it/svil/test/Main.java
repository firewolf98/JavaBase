package org.it.svil.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il primo numero:");
        int a = scanner.nextInt();
        System.out.println("Inserisci il secondo numero:");
        int b = scanner.nextInt();
        System.out.println("La moltiplicazione tra i due e': " + a*b);
        scanner.close();
    }
}