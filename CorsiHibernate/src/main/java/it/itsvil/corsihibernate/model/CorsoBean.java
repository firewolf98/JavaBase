package it.itsvil.corsihibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "corsi")
public class CorsoBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "durata")
    private int durata;

    @Column(name = "stato")
    private String stato;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private TutorBean tutor;

    public CorsoBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

