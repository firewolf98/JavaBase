package org.it.svil.test;

import org.it.svil.animali.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animali> animali = new ArrayList<>();

        animali.add(new Gatto("Persiano", "Felix"));
        animali.add(new Serpente("Pitone","Piton"));
        animali.add(new Cane("Pastore Tedesco","Rex"));
        animali.add(new Tartaruga("Terra","Raffaello"));
        animali.add(new Uccelli("Rondine","Rondinella"));

        animali.forEach(a->System.out.println(a));

        animali.forEach(Animali::mangia);
        System.out.println("Dopo aver fatto mangiare tutti!");
        animali.forEach(Animali::mangia);

        for(Animali animale: animali) {
            if(animale instanceof Gatto || animale instanceof Cane)
                ((Corre) animale).corre();
            else if (animale instanceof Uccelli)
                ((Uccelli) animale).vola();
            else if (animale instanceof Serpente)
                ((Serpente) animale).striscia();
            else if (animale instanceof Tartaruga)
                ((Tartaruga) animale).cammina();
        }
    }
}