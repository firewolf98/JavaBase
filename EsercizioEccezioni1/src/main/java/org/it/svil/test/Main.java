package org.it.svil.test;

import org.it.svil.eccezioni.InputLitriException;
import org.it.svil.eccezioni.ValueTypeException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        try {
            int litri = inputLitri(scanner);
            int chilometri = inputChilometri(scanner);
            double consumo = calcolaConsumo(litri, chilometri);
            System.out.println("Il consumo dell'automobile è di " + consumo + " km/l.");
        } catch (InputLitriException | ValueTypeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Uscita dal programma...");
            scanner.close();
        }
    }

    public static int inputChilometri(Scanner scanner) {
        System.out.println("Inserisci i chilometri percorsi:");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputLitri(Scanner scanner) throws InputLitriException {
        System.out.println("Inserisci i litri:");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new InputLitriException();
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ValueTypeException();
        }
    }

    public static double calcolaConsumo(int litri, int chilometri) {
        return (double) chilometri / litri;
    }
}