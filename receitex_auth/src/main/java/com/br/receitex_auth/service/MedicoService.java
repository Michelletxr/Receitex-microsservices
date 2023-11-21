package com.br.receitex_auth.service;


import com.br.receitex_auth.models.Medico;
import com.br.receitex_auth.models.UserRole;
import com.br.receitex_auth.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public record MedicoRequestDTO( String first_name, String last_name){}

    public List<Medico> getMedicos(){

        return (List<Medico>) repository.findAll();
    }

    public Medico createMedico (MedicoRequestDTO medico)
    {
        Medico newMedico = null;
        newMedico = repository.save(new Medico(medico.first_name, medico.last_name));
        return newMedico;
    }

    public Optional<Medico> findOne (UUID id){
        return repository.findById(id);

    }

    public  Boolean deleteEntity(UUID id){
        Optional<Medico> m =repository.findById(id);
                if(m.isEmpty()){
                    return false;
                }

                repository.delete(m.get());
                return true;
    }

    public Optional<Medico> updateEntity(Medico update, UUID id) {
        Optional<Medico> p = repository.findById(id);
        if (p.isEmpty()) {
            return Optional.empty();
        }
        repository.save(p.get());
        return p;
    }
}
