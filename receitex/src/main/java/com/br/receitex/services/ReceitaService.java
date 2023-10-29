package com.br.receitex.services;

import com.br.receitex.Repositories.ReceitaRepository;
import com.br.receitex.models.Documento;
import com.br.receitex.models.Receita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ReceitaService{
    @Autowired
    ReceitaRepository repository;

    public String gerarCodigo(){
        UUID codigo = UUID.randomUUID();
        byte[] uuidBytes = new byte[16];
        long mostSigBits = codigo.getMostSignificantBits();
        long leastSigBits = codigo.getLeastSignificantBits();

        for (int i = 0; i < 8; i++) {
            uuidBytes[i] = (byte) (mostSigBits >>> 8 * (7 - i));
            uuidBytes[8 + i] = (byte) (leastSigBits >>> 8 * (7 - i));
        }
        String codigoFinal = Base64.getEncoder().encodeToString(uuidBytes);
        System.out.println("CODIGO FINAL GERADO: " + codigoFinal);
        return codigoFinal;
    }


    public Documento createDocumento(Receita data){
        Receita receita = new Receita();
        receita.setTitulo(data.getTitulo());
        receita.setDescricao(data.getDescricao());
        receita.setEmissao(data.getEmissao());
        receita.setVencimento(data.getVencimento());
        receita.setNome_medico(data.getNome_medico());
        receita.setNome_paciente(data.getNome_paciente());
        receita.setCodido(this.gerarCodigo());
        repository.save(receita);
        return receita;
    }

    public Receita getDocumentoById(Long id){
        Optional<Receita> receita =repository.findById(id);
        if(receita.isPresent()){
            return receita.get();
        }
        else{
            return null;
        }

    }

    public List<Receita> getAllDocumentos(){
        return repository.findAll();
    }

    public void deleteReceitaById(Long id){
        repository.deleteById(id);
    }

    public void deleteReceita(Receita receita){
        repository.delete(receita);
    }

    public Receita updateReceita(Long id, Receita receita_nova){
        Optional<Receita> receita_antiga = repository.findById(id);
        if(receita_antiga.isPresent()){
            Receita receita = receita_antiga.get();

            if(receita_nova.getTitulo() != null) receita.setTitulo(receita_nova.getTitulo());
            if(receita_nova.getDescricao() != null) receita.setDescricao(receita_nova.getDescricao());
            if(receita_nova.getVencimento() != null) receita.setVencimento(receita_nova.getVencimento());
            if(receita_nova.getNome_medico() != null) receita.setNome_medico(receita_nova.getNome_medico());
            if(receita_nova.getNome_paciente() != null) receita.setNome_paciente(receita_nova.getNome_paciente());

            repository.save(receita);
            return receita;
        }
        else{
            return null;
        }
    }


}
