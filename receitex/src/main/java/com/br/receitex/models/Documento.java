package com.br.receitex.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public abstract class Documento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome_medico;
    private String nome_paciente;

    private String titulo;
    private String descricao;

    private UUID paciente_id;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome_medico() {
        return nome_medico;
    }

    public String getNome_paciente() {
        return nome_paciente;
    }

    public void setNome_medico(String nome_medico) {
        this.nome_medico = nome_medico;
    }

    public void setNome_paciente(String nome_paciente) {
        this.nome_paciente = nome_paciente;
    }

    public UUID getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(UUID paciente_id) {
        this.paciente_id = paciente_id;
    }
}
