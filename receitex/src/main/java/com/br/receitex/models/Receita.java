package com.br.receitex.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity(name = "receita")
@Table(name="receita", schema = "public")
public class Receita extends Documento {

    private String codido;
    private Date emissao;
    private Date vencimento;


    public String getCodido() {
        return codido;
    }

    public void setCodido(String codido) {
        this.codido = codido;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

}
