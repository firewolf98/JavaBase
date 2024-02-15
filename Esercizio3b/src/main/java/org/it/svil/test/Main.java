package org.it.svil.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci un numero: ");
        int n = scanner.nextInt();

        String result = (n % 3 == 0) ? "Il numero è multiplo di 3" : "Il numero non è multiplo di 3";
        System.out.println(result);

        scanner.close();
    }
}
