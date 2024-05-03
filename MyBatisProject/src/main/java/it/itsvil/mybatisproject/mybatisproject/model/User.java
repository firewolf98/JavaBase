package it.itsvil.mybatisproject.mybatisproject.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
}
