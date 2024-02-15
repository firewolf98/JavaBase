package org.it.svil.animali;

public abstract class Volanti extends Animali{
    private boolean staVolando;
    public Volanti() {
        super();
        this.staVolando = false;
    }

    public Volanti(String specie, String nome) {
        super(specie, nome);
        this.staVolando = false;
    }

    public boolean isStaVolando() {
        return staVolando;
    }

    public void setStaVolando(boolean staVolando) {
        this.staVolando = staVolando;
    }

    public abstract void vola();
}
