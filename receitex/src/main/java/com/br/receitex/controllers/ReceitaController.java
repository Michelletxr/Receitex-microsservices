package com.br.receitex.controllers;

import com.br.receitex.models.Documento;
import com.br.receitex.models.Receita;
import com.br.receitex.services.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("/receita")
@RestController
public class ReceitaController {

    @Autowired
    ReceitaService receitaService;
    @PostMapping("/receita")
    public Documento createDocumento(@RequestBody Receita receita){

       return receitaService.createDocumento(receita);
    }
}
