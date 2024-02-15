package org.it.svil.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rubrica {
    private List<Contatto> contatti;

    public Rubrica() {
        this.contatti = new ArrayList<>();
    }

    public Rubrica(List<Contatto> contatti) {
        this.contatti = contatti;
    }

    public void aggiungiContatto(String nome, String cognome, String telefono) {
        this.contatti.add(new Contatto(nome,cognome,telefono));
    }

    public void rimuoviContatto(String nome, String cognome) {
        Iterator<Contatto> iterator = this.contatti.iterator();
        while (iterator.hasNext()) {
            Contatto contatto = iterator.next();
            if (contatto.getCognome().equals(cognome) && contatto.getNome().equals(nome)) {
                iterator.remove();
            }
        }
    }


    public String cerca(String nome, String cognome){
        for(Contatto contatto: this.contatti)
            if(contatto.getCognome() == cognome && contatto.getNome() == nome)
                return contatto.getTelefono();
        return null;
    }

    @Override
    public String toString() {
        return "Rubrica{" +
                "contatti=" + contatti +
                '}';
    }
}
