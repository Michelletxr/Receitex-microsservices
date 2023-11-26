package com.br.receitex_auth.service;

import com.br.receitex_auth.models.Medico;
import com.br.receitex_auth.models.Paciente;
import com.br.receitex_auth.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository repository;

    public record PacienteRequestDTO(String first_name, String last_name){}
    public record PacienteResponseDTO(UUID medico_id, String first_name, String last_name){}
    public PacienteResponseDTO buildPacienteToPacienteDTO(Paciente paciente){
        return new PacienteResponseDTO(paciente.getId(), paciente.getFirstName(), paciente.getLastName());
    }

    public List<Paciente> getPacientes() {
        return repository.findAll();
    }


    public Paciente createPaciente (PacienteRequestDTO paciente) {
        Paciente newPaciente = null;
        newPaciente = repository.save(new Paciente(paciente.first_name, paciente.last_name));
        return newPaciente;
    }

    public Optional<Paciente> findOne(UUID pacientId) {
        return repository.findById(pacientId);
    }

    public Paciente updateEntity(Paciente update, UUID id) {
        Optional<Paciente> p = repository.findById(id);
        if (p.isEmpty()) {
            return null;
        }
        return repository.save(update);
    }

    public  Boolean deleteEntity(UUID id) {
        Optional<Paciente> p =repository.findById(id);
        if(p.isEmpty()){
            return false;
        }
        repository.delete(p.get());
        return true;
    }
}
