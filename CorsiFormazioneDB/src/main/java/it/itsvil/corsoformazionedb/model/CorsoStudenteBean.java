package it.itsvil.corsoformazionedb.model;

import java.io.Serializable;

public class CorsoStudenteBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private CorsoBean corso;
    private StudenteBean studente;

    public CorsoStudenteBean() {
    }

    public CorsoBean getCorso() {
        return corso;
    }

    public void setCorso(CorsoBean corso) {
        this.corso = corso;
    }

    public StudenteBean getStudente() {
        return studente;
    }

    public void setStudente(StudenteBean studente) {
        this.studente = studente;
    }

    @Override
    public String toString() {
        return "CorsoStudenteBean{" +
                "corso=" + corso +
                ", studente=" + studente +
                '}';
    }
}
