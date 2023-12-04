package com.br.receitex.services;

import com.br.receitex.Repositories.RequisicaoRepository;
import com.br.receitex.models.Atestado;
import com.br.receitex.models.Documento;
import com.br.receitex.models.Requisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RequisicaoService {

    @Autowired
    RequisicaoRepository repository;

    public Documento createDocumento(Requisicao data){
        Requisicao requisicao = new Requisicao();
        requisicao.setTitulo(data.getTitulo());
        requisicao.setDescricao(data.getDescricao());
        requisicao.setEmissao(data.getEmissao());
        requisicao.setNome_medico(data.getNome_medico());
        requisicao.setNome_paciente(data.getNome_paciente());
        requisicao.setPaciente_id(data.getPaciente_id());
        repository.save(requisicao);
        return requisicao;
    }

    public Requisicao getDocumentoById(Long id){
        Optional<Requisicao> requisicao = repository.findById(id);
        if(requisicao.isPresent()){
            return requisicao.get();
        }
        else{
            return null;
        }

    }

    public List<Requisicao> getAllDocumentos(){
        return repository.findAll();
    }

    public List<Requisicao> getDocumentoByPacienteId(UUID id) {
        List<Requisicao> requisicaos = repository.findAll();
        List<Requisicao> requisicaosPaciente = new ArrayList<>();
        for (Requisicao r: requisicaos) {
            if(r.getPaciente_id().equals(id)){
                requisicaosPaciente.add(r);
            }
        }
        return requisicaosPaciente;
    }

    public void deleteRequisicaoById(Long id){
        repository.deleteById(id);
    }

    public void deleteRequisicao(Requisicao requisicao){
        repository.delete(requisicao);
    }

    public Requisicao updateRequisicao(Long id, Requisicao requisicao_nova){
        Optional<Requisicao> requisicao_antiga = repository.findById(id);
        if(requisicao_antiga.isPresent()){
            Requisicao requisicao = requisicao_antiga.get();

            if(requisicao_nova.getTitulo() != null) requisicao.setTitulo(requisicao_nova.getTitulo());
            if(requisicao_nova.getDescricao() != null) requisicao.setDescricao(requisicao_nova.getDescricao());
            if(requisicao_nova.getNome_medico() != null) requisicao.setNome_medico(requisicao_nova.getNome_medico());
            if(requisicao_nova.getNome_paciente() != null) requisicao.setNome_paciente(requisicao_nova.getNome_paciente());

            repository.save(requisicao);
            return requisicao;
        }
        else{
            return null;
        }
    }
}
