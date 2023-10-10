package com.br.receitex.controllers;

import com.br.receitex.models.Documento;
import com.br.receitex.services.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/document")
@RestController
public class DocumentController {

    @Autowired
    private DocumentoService service;

    //rota para teste
    @GetMapping("/hello")
    public String hello(){
        return "HELLO";
    }

    @GetMapping
    public List<Documento> getDocumentos(){
        return service.getDocumentos();
    }

    @GetMapping("/{id}")
    public Documento getDocumentoById(@PathVariable Long id){
        return service.getDocumentoById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDocumento(@PathVariable Long id){
        service.deleteDocumento(id);
    }
}
