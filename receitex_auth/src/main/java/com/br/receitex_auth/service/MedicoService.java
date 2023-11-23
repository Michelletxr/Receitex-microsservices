package com.br.receitex_auth.service;


import com.br.receitex_auth.models.Medico;
import com.br.receitex_auth.models.Paciente;
import com.br.receitex_auth.models.UserRole;
import com.br.receitex_auth.repositories.MedicoRepository;
import com.br.receitex_auth.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    PacienteRepository pacienteRepository;
    public record MedicoRequestDTO( String first_name, String last_name){}
    public record AddPacienteDTO(UUID paciente_id, UUID medico_id){}

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


    @Transactional
    public void adicionarPacienteAoMedico(UUID medicoId, UUID pacienteId) {
        Medico medico = repository.findById(medicoId)
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado com o ID: " + medicoId));

        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado com o ID: " + pacienteId));

        paciente.getDoctors().add(medico);
        pacienteRepository.save(paciente);
        //System.out.println("resultado DENTRO DO SERVICE" + paciente.getFirstName() + " " + paciente.getDoctors());

    }
}
