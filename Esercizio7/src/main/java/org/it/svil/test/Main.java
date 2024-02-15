package org.it.svil.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il primo numero:");
        float a = Float.parseFloat(scanner.nextLine());
        System.out.println("Inserisci il secondo numero:");
        float b = Float.parseFloat(scanner.nextLine());
        System.out.println("La somma è: " + sum(a,b));

        System.out.println(nameSurname(scanner));

        System.out.println("Inserisci il primo numero:");
        int n1 = scanner.nextInt();
        System.out.println("Inserisci il secondo numero:");
        int n2 = scanner.nextInt();
        System.out.println("Inserisci il terzo numero:");
        int n3 = scanner.nextInt();
        System.out.println("Inserisci il quarto numero:");
        int n4 = scanner.nextInt();
        System.out.println("Il risultato è: " + sum10(n1, n2, n3, n4));

        System.out.println("Inserisci una stringa:");
        scanner.nextLine();
        String string = scanner.nextLine();
        System.out.println(stringQuad(string));

        scanner.close();
    }

    public static float sum(float a, float b){
        return a+b;
    }

    public static String nameSurname(Scanner scanner) {
        System.out.println("Inserisci nome:");
        String name = scanner.nextLine();
        System.out.println("Inserisci cognome:");
        String surname = scanner.nextLine();
        return "Il tuo nome è " + name + ",il tuo cognome è " + surname;
    }

    public static int sum10(int a, int b, int c, int d) {
        return (a+b+c+d)*10;
    }

    public static String stringQuad(String string) {
        return "[" + string + "]";
    }
}