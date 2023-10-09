package com.br.receitex.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Atestado extends Documento{

    private Date emissao;
    private Date vencimento;
}
