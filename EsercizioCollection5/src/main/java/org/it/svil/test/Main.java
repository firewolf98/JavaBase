package org.it.svil.test;

import org.it.svil.model.Contatti;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        List<Contatti> cont = new ArrayList<>();

        cont.add(new Contatti("Paolo","Rossi",335403430));
        cont.add(new Contatti("Paolo","Verdi",320302130));
        cont.add(new Contatti("Mimmo","Esposito",453303030));
        cont.add(new Contatti("Diego","Abatantuono",55403030));
        cont.add(new Contatti("Antonio","Belari",9703030));

        Map<String,Integer> contatti = new TreeMap<>(ordinaContatti(cont));
        contatti.forEach((k,v)->System.out.println("Cliente: "+k+" - Numero: "+v));
    }

    private static Map<String,Integer> ordinaContatti(List<Contatti> cont) {
        Map<String,Integer> contatti = new TreeMap<>();
        for (Contatti contatto : cont) {
            contatti.put(contatto.getCognome()+" "+contatto.getNome(), contatto.getTelefono());
        }
        return contatti;
    }
}