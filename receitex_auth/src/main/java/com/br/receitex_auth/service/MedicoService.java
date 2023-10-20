package com.br.receitex_auth.service;


import com.br.receitex_auth.models.Medico;
import com.br.receitex_auth.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public List<Medico> getMedicos(){

        return (List<Medico>) repository.findAll();
    }

    public Medico createMedico (Medico medico){
        return repository.save(medico);
    }

    public Optional<Medico> findOne (long id){
        return repository.findById(id);

    }

    public  Boolean deleteEntity(Long id){
        Optional<Medico> m =repository.findById(id);
                if(m.isEmpty()){
                    return false;
                }

                repository.delete(m.get());
                return true;
    }

    public Optional<Medico> updateEntity(Medico update, Long id) {
        Optional<Medico> p = repository.findById(id);
        if (p.isEmpty()) {
            return Optional.empty();
        }
        repository.save(p.get());
        return p;
    }
}
