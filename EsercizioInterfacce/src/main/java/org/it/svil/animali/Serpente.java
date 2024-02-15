package org.it.svil.animali;

public class Serpente extends Rettili implements Striscia{

    public Serpente() {
        super();
    }

    public Serpente(String specie, String nome) {
        super(specie, nome);
    }
    @Override
    public void mangia() {
        if(isHaMangiato())
            System.out.println("Ssssss non ho fame!");
        else {
            setHaMangiato(true);
            System.out.println("SSSGrazie! Vuoi una mela anche tu?");
        }
    }

    @Override
    public void striscia() {
        System.out.println("Ssssto strisciando!");
    }
}
