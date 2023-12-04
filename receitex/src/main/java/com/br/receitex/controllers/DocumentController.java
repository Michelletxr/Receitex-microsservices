package com.br.receitex.controllers;

import com.br.receitex.models.Documento;
import com.br.receitex.services.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

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

    @GetMapping("/paciente/{id}")
    public Map<String, ArrayList<Documento>> getDocumentosByPacienteId(@PathVariable UUID id){
        return service.getDocumentosByPacienteId(id);
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
