package it.itsvil.springcorsi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "corsi_studenti")
public class CorsoStudenteBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "corso_id")
    private CorsoBean corso;

    @ManyToOne
    @JoinColumn(name = "studente_id")
    private StudenteBean studente;

    public CorsoStudenteBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
