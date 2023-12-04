package com.br.receitex.services;

import com.br.receitex.Repositories.DocumentoRepository;
import com.br.receitex.models.Atestado;
import com.br.receitex.models.Documento;
import com.br.receitex.models.Receita;
import com.br.receitex.models.Requisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository repository;
    @Autowired
    ReceitaService receitaService;
    @Autowired
    RequisicaoService requisicaoService;
    @Autowired
    AtestadoService atestadoService;

    public Map<String, ArrayList<Documento>> getDocumentosByPacienteId(UUID id){
        List<Receita> receitas = receitaService.getDocumentoByPacienteId(id);
        List<Atestado> atestados = atestadoService.getDocumentoByPacienteId(id);
        List<Requisicao> requisicoes = requisicaoService.getDocumentoByPacienteId(id);
        Map<String, ArrayList<Documento>> documentos = new HashMap<>();
        documentos.put("receitas", (ArrayList) receitas);
        documentos.put("atestados", (ArrayList) atestados);;
        documentos.put("requisicoes", (ArrayList) requisicoes);;
        return documentos;

    }

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
