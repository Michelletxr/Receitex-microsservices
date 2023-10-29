package com.br.receitex.controllers;

import com.br.receitex.models.Documento;
import com.br.receitex.models.Requisicao;
import com.br.receitex.services.RequisicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequisicaoController {
    @Autowired
    RequisicaoService requisicaoService;
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/requisicao")
    public Documento createDocumento(@RequestBody Requisicao requisicao){
        return requisicaoService.createDocumento(requisicao);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/requisicao")
    public Requisicao getDocumentoById(@RequestParam Long id){
        return requisicaoService.getDocumentoById(id);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/requisicoes")
    public List<Requisicao> getAllDocumentos(){
        return requisicaoService.getAllDocumentos();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("requisicao")
    public void deleteReceitaById(@RequestParam Long id){
        requisicaoService.deleteRequisicaoById(id);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("deletar_requisicao")
    public void deleteReceita(@RequestBody Requisicao requisicao){
        requisicaoService.deleteRequisicao(requisicao);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("update_requisicao")
    public Requisicao updateReceita(@RequestParam Long id, @RequestBody Requisicao requisicao_nova){
        System.out.println("Editando requisicao");
        return requisicaoService.updateRequisicao(id, requisicao_nova);
    }
}
