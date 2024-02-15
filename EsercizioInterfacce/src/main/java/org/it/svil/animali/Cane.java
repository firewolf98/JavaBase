package org.it.svil.animali;

public class Cane extends Mammiferi implements Corre{

    public Cane() {
        super();
    }

    public Cane(String specie, String nome) {
        super(specie,nome);
    }
    @Override
    public void mangia() {
        if (isHaMangiato())
            System.out.println(getNome() + " ha già mangiato oggi!");
        else {
            setHaMangiato(true);
            System.out.println(getNome() + " ti ringrazia per il cibo!");
        }
    }

    @Override
    public void corre() {
        System.out.println("Guardaaaa vado a prendere la pallinaaa!");
    }
}
