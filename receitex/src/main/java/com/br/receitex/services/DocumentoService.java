package com.br.receitex.services;
import com.br.receitex.Repositories.DocumentoRepository;
import com.br.receitex.models.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository repository;


    public List<Documento> getDocumentos(){
       Iterable<Documento> documentosIterable = repository.findAll();
       List<Documento> documentos = new ArrayList<>();
       documentosIterable.forEach(documentos::add);
      return documentos;

    }


    public Documento getDocumentoById(Long id){
      Optional<Documento> documentoOptional = repository.findById(id);
      if(documentoOptional.isPresent()){
            return documentoOptional.get();
        }
        else{
            return null;
        }
    }

    public void deleteDocumento(Long id){
        repository.deleteById(id);
    }




}
