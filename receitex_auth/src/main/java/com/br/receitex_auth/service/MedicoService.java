package com.br.receitex_auth.service;


import com.br.receitex_auth.models.Medico;
import com.br.receitex_auth.models.Paciente;
import com.br.receitex_auth.repositories.MedicoRepository;
import com.br.receitex_auth.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;
    @Autowired
    PacienteRepository pacienteRepository;
    public record MedicoRequestDTO(String first_name, String last_name){}
    public record MedicoResponseDTO(UUID medico_id, String first_name, String last_name){}
    public record AddPacienteDTO(UUID paciente_id, UUID medico_id){}

    public MedicoResponseDTO buildMedicoToMedicoDTO(Medico medico) {
        return new MedicoResponseDTO(medico.getId(), medico.getFirstName(), medico.getLastName());
    }

    public List<Medico> getMedicos() {
        return (List<Medico>) repository.findAll();
    }

    public Medico createMedico (MedicoRequestDTO medico) {
        Medico newMedico = null;
        newMedico = repository.save(new Medico(medico.first_name, medico.last_name));
        return newMedico;
    }

    public Optional<Medico> findOne (UUID id){
        return repository.findById(id);

    }

    public  Boolean deleteEntity(UUID id) {
        Optional<Medico> m =repository.findById(id);
                if(m.isEmpty()) {
                    return false;
                }
                repository.delete(m.get());
                return true;
    }

    public Medico updateEntity(Medico update, UUID id) {
        Optional<Medico> m = repository.findById(id);
        if (m.isEmpty()) {
            return null;
        }
        return repository.save(update);
    }


    @Transactional
    public Paciente adicionarPacienteAoMedico(UUID medicoId, UUID pacienteId) {
        Medico medico = repository.findById(medicoId)
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado com o ID: " + medicoId));

        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado com o ID: " + pacienteId));

        paciente.getDoctors().add(medico);
        medico.getPatients().add(paciente);
        repository.save(medico);
        return paciente;


    }
}
