package it.itsvil.corsoformazionedb.model;

import java.io.Serializable;

public class CorsoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id, durata;
    private String nome, stato;
    private TutorBean tutor;

    public CorsoBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public TutorBean getTutor() {
        return tutor;
    }

    public void setTutor(TutorBean tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "CorsoBean{" +
                "id=" + id +
                ", durata=" + durata +
                ", nome='" + nome + '\'' +
                ", stato='" + stato + '\'' +
                ", tutor=" + tutor +
                '}';
    }
}
