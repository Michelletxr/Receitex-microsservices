package com.br.receitex.services;

import com.br.receitex.Repositories.AtestadoRepository;
import com.br.receitex.models.Atestado;
import com.br.receitex.models.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AtestadoService {
    @Autowired
    AtestadoRepository repository;


    public Documento createDocumento(Atestado data){
        Atestado atestado = new Atestado();
        atestado.setTitulo(data.getTitulo());
        atestado.setDescricao(data.getDescricao());
        atestado.setEmissao(data.getEmissao());
        atestado.setVencimento(data.getVencimento());
        atestado.setNome_medico(data.getNome_medico());
        atestado.setNome_paciente(data.getNome_paciente());
        repository.save(atestado);
        return atestado;
    }

    public Atestado getDocumentoById(Long id){
        Optional<Atestado> atestado =repository.findById(id);
        if(atestado.isPresent()){
            return atestado.get();
        }
        else{
            return null;
        }

    }

    public List<Atestado> getAllDocumentos(){
        return repository.findAll();
    }

    public void deleteAtestadoById(Long id){
        repository.deleteById(id);
    }

    public void deleteAtestado(Atestado atestado){
        repository.delete(atestado);
    }

    public Atestado updateReceita(Long id, Atestado atestado_novo){
        Optional<Atestado> atestado_antigo = repository.findById(id);
        if(atestado_antigo.isPresent()){
            Atestado atestado = atestado_antigo.get();

            if(atestado_novo.getTitulo() != null) atestado.setTitulo(atestado_novo.getTitulo());
            if(atestado_novo.getDescricao() != null) atestado.setDescricao(atestado_novo.getDescricao());
            if(atestado_novo.getVencimento() != null) atestado.setVencimento(atestado_novo.getVencimento());
            if(atestado_novo.getNome_medico() != null) atestado.setNome_medico(atestado_novo.getNome_medico());
            if(atestado_novo.getNome_paciente() != null) atestado.setNome_paciente(atestado_novo.getNome_paciente());

            repository.save(atestado);
            return atestado;
        }
        else{
            return null;
        }
    }
}
