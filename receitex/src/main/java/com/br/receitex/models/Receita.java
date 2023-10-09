package com.br.receitex.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="receita", schema = "public")
public class Receita extends Documento {
    private Long codido;
    private Date emissao;
    private Date vencimento;

}
