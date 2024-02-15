package org.it.svil.animali;

public class Gatto extends Mammiferi implements Corre{

    public Gatto() {
        super();
    }

    public  Gatto(String specie, String nome) {
        super(specie, nome);
    }
    @Override
    public void mangia() {
        if(isHaMangiato())
            System.out.println(getNome() + " ha già mangiato per oggi!");
        else {
            setHaMangiato(true);
            System.out.println(getNome() + " ha mangiato tutto in 2 secondi!");
        }
    }

    @Override
    public void corre() {
        System.out.println("Miaoooooooo non mi prendi!");
    }
}
