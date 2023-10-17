package com.br.receitex.models;

import jakarta.persistence.*;

@Entity(name = "usuario")
@Table(name="usuario", schema = "public")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
