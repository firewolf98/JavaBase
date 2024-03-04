package it.itsvil.loginhibernate.model;

import jakarta.persistence.*;


@Entity
@Table(name = "utenti")
public class UtenteBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "pw", nullable = false, length = 50)
    private String password;

    @Column(name = "nome", nullable = false, length = 30)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 30)
    private String cognome;

    public UtenteBean() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}



