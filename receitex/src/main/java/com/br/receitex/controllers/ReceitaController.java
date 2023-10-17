package com.br.receitex.controllers;

import com.br.receitex.models.Documento;
import com.br.receitex.models.Receita;
import com.br.receitex.services.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("/receita")
@RestController
public class ReceitaController {

    @Autowired
    ReceitaService receitaService;
    @PostMapping("/receita")
    public Documento createDocumento(@RequestBody Receita receita){
       return receitaService.createDocumento(receita);
    }

    @GetMapping("/receita")
    public Receita getDocumentoById(@RequestParam Long id){
        return receitaService.getDocumentoById(id);
    }

    @GetMapping("/receitas")
    public List<Receita> getAllDocumentos(){
        return receitaService.getAllDocumentos();
    }

    @DeleteMapping("receita")
    public void deleteReceitaById(@RequestParam Long id){
        receitaService.deleteReceitaById(id);
    }

    @DeleteMapping("deletar_receita")
    public void deleteReceita(@RequestBody Receita receita){
        receitaService.deleteReceita(receita);
    }

    @PostMapping("update_receita")
    public Receita updateReceita(@RequestParam Long id, @RequestBody Receita receita_nova){
        return receitaService.updateReceita(id, receita_nova);
    }
}
