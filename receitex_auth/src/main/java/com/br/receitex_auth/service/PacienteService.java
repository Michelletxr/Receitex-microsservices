package com.br.receitex_auth.service;

import com.br.receitex_auth.models.Paciente;
import com.br.receitex_auth.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository repository;
    public record PacienteRequestDTO(String first_name, String last_name){}

    public Paciente createPaciente (PacienteRequestDTO paciente)
    {
        Paciente newPaciente = null;
        newPaciente = repository.save(new Paciente(paciente.first_name, paciente.last_name));
        return newPaciente;
    }
}
