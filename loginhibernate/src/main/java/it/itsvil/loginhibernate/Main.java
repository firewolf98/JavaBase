package it.itsvil.loginhibernate;

import it.itsvil.loginhibernate.controller.UtenteCRUD;
import it.itsvil.loginhibernate.model.UtenteBean;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        boolean logged = false;
        while(flag) {
            int scelta = menu(scanner);
            switch(scelta) {
                case 0:
                    UtenteBean utente = register(scanner);
                    UtenteCRUD.insertUtente(utente);
                    break;
                case 1:
                    if(logged) {
                        System.out.println("Login già effettuato!");
                    } else {
                        if(login(scanner))
                            logged = true;
                        else
                            System.out.println("Utente non esistente");
                    }
                    break;
                case 2:
                    if(logged)
                        logged=false;
                    else
                        System.out.println("Logout già effettuato!");
                    break;
                case 3:
                    flag=false;
                    break;
                default:
                    System.out.println("Scelta non valida!");
                    break;
            }
        }
    }

    private static int menu(Scanner scanner) {
        System.out.println("""
                    Cosa vuoi fare?
                     0- Registrati
                     1- Login
                     2- Logout
                     3- Termina""");
        return scanner.nextInt();
    }
    public static UtenteBean register(Scanner scanner) {
        scanner.nextLine();
        UtenteBean utente = new UtenteBean();
        System.out.println("Inserisci l'username");
        utente.setUsername(scanner.nextLine());
        System.out.println("Inserisci la password");
        utente.setPassword(scanner.nextLine());
        System.out.println("Inserisci il nome");
        utente.setNome(scanner.nextLine());
        System.out.println("Inserisci il cognome");
        utente.setCognome(scanner.nextLine());
        return utente;
    }

    public static boolean login(Scanner scanner) {
        scanner.nextLine();
        UtenteBean utente = new UtenteBean();
        System.out.println("Inserisci l'username");
        utente.setUsername(scanner.nextLine());
        System.out.println("Inserisci la password");
        utente.setPassword(scanner.nextLine());
        UtenteBean result = UtenteCRUD.selectUtente(utente);
        if(result != null)
            return true;
        return false;
    }
}