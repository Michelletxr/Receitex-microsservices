package com.br.receitex_auth.service;

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

    public List<Paciente> getPacientes() {
        return repository.findAll();
    }

    public record PacienteRequestDTO(String first_name, String last_name){}

    public Paciente createPaciente (PacienteRequestDTO paciente) {
        Paciente newPaciente = null;
        newPaciente = repository.save(new Paciente(paciente.first_name, paciente.last_name));
        return newPaciente;
    }

    public Optional<Paciente> findOne(UUID pacientId) {
        return repository.findById(pacientId);
    }

    public Paciente updateEntity(Paciente update) {
        return repository.save(update);
    }
}
