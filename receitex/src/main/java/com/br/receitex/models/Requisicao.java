package com.br.receitex.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Requisicao extends Documento{
    private Date emissao;
}
