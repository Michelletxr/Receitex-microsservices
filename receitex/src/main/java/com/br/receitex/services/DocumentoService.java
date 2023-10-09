package com.br.receitex.services;

import com.br.receitex.Repositories.DocumentoRepository;
import com.br.receitex.models.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DocumentoService {

    @Autowired
    private DocumentoRepository repository;


    public Documento createDocumento(Documento document){
        return repository.save(document);
    }

    @GetMapping("/hello")
    public String hello(){
        return "HELLO";
    }

    @GetMapping("documents")
    public List<Documento> getDocumentos(){
        Iterable<Documento> documentosIterable = repository.findAll();
        List<Documento> documentos = new ArrayList<>();

        documentosIterable.forEach(documentos::add);
        return documentos;
    }

    @GetMapping("/document")
    public Documento getDocumentoById(@RequestBody Long id){
        Optional<Documento> documentoOptional = repository.findById(id);
        if(documentoOptional.isPresent()){
            return documentoOptional.get();
        }
        else{
            return null;
        }
    }

    @DeleteMapping("/document")
    public void deleteDocumento(@RequestBody Long id){
        repository.deleteById(id);
    }




}
