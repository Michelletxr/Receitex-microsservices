package com.br.receitex.controllers;

import com.br.receitex.models.Atestado;
import com.br.receitex.models.Documento;
import com.br.receitex.services.AtestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AtestadoController {

    @Autowired
    AtestadoService atestadoService;
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/atestado")
    public Documento createDocumento(@RequestBody Atestado atestado){
        return atestadoService.createDocumento(atestado);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/atestado")
    public Atestado getDocumentoById(@RequestParam Long id){
        return atestadoService.getDocumentoById(id);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/atestados")
    public List<Atestado> getAllDocumentos(){
        return atestadoService.getAllDocumentos();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("atestado")
    public void deleteReceitaById(@RequestParam Long id){
        atestadoService.deleteAtestadoById(id);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("deletar_atestado")
    public void deleteReceita(@RequestBody Atestado atestado){
        atestadoService.deleteAtestado(atestado);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("update_atestado")
    public Atestado updateReceita(@RequestParam Long id, @RequestBody Atestado atestado_novo){
        return atestadoService.updateReceita(id, atestado_novo);
    }
}
