package org.it.svil.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero:");
        int n = scanner.nextInt();
        if (n>0)
            System.out.println("il numero è positivo");
        else if (n==0)
            System.out.println("Il numero è uguale a 0");
        else
            System.out.println("Il numero è negativo");

        // Un modo equivalente è:
        // System.out.println(n > 0 ? "il numero è positivo" : (n == 0 ? "Il numero è uguale a 0" : "Il numero è negativo"));
        scanner.close();
    }
}