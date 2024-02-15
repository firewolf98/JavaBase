package org.it.svil.animali;

public class Uccelli extends Volanti{

    public Uccelli() {
        super();
    }

    public Uccelli(String specie, String nome) {
        super(specie, nome);
    }

    @Override
    public void vola() {
        if(isStaVolando()) {
            setStaVolando(false);
            System.out.println("Basta volare, sono stanco!");
        } else {
            setStaVolando(true);
            System.out.println("Mi alzo in volo");
        }
    }

    @Override
    public void mangia() {
        if(isHaMangiato())
            System.out.println("Grazie ma non ho fame!");
        else {
            setHaMangiato(true);
            System.out.println("Grazie per le briciole!");
        }
    }
}
