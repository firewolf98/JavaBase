package org.it.svil.animali;

public class Tartaruga extends Rettili implements Cammina{
    public Tartaruga() {
        super();
    }

    public Tartaruga(String specie, String nome) {
        super(specie, nome);
    }
    @Override
    public void mangia() {
        if(isHaMangiato())
            System.out.println("Ho già mangiato, ora sono in letargo");
        else {
            setHaMangiato(true);
            System.out.println("Grazie per l'insalata!");
        }
    }

    @Override
    public void cammina() {
        System.out.println("Che fatica camminare! Non posso andare in letargo?");
    }
}
