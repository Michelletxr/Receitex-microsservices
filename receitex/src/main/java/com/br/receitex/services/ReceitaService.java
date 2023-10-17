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
}
