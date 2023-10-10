package com.br.receitex.services;

import com.br.receitex.Repositories.ReceitaRepository;
import com.br.receitex.models.Documento;
import com.br.receitex.models.Receita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService{
    @Autowired
    ReceitaRepository repository;

    public Documento createDocumento(Receita data){
        Receita receita = new Receita();
        String titulo = data.getTitulo();
        receita.setTitulo(titulo);
        String descricao = data.getDescricao();
        receita.setDescricao(descricao);
        return receita;
    }
}
