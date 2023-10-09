package com.br.receitex.services;

import com.br.receitex.models.Documento;
import com.br.receitex.models.Receita;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/receita")
public class ReceitaService extends DocumentoService{
    @PostMapping
    public Documento createDocumento(){
        Receita receita = new Receita();
//        String titulo = (String) data.get("titulo");
//        receita.setTitulo(titulo);
//        String descricao = (String) data.get("descricao");
//        receita.setDescricao(descricao);
        return receita;
//        return createDocumento(receita);
    }
}
