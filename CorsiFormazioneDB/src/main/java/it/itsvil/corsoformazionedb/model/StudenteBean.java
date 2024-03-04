package it.itsvil.corsoformazionedb.model;

import java.io.Serializable;

public class StudenteBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nome, cognome;

    public StudenteBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "StudenteBean{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
