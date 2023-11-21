package com.br.receitex_auth.controllers;

import com.br.receitex_auth.models.Medico;
import com.br.receitex_auth.models.Paciente;
import com.br.receitex_auth.repositories.MedicoRepository;
import com.br.receitex_auth.repositories.PacienteRepository;
import com.br.receitex_auth.service.PacienteService;
import jakarta.ws.rs.PUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/paciente")
@RestController
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteRepository repository;
    @Autowired
    private MedicoRepository medicoRepository;
    public record AddMedicoDTO(UUID paciente_id, UUID medico_id){}
    @PostMapping()
    public ResponseEntity createPaciente(@RequestBody PacienteService.PacienteRequestDTO paciente){

        Paciente response = pacienteService.createPaciente(paciente);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "addMedico")
    public ResponseEntity addMedico(@RequestBody AddMedicoDTO addMedicoDTO){
        Optional<Paciente> paciente = repository.findById(addMedicoDTO.paciente_id);
        Paciente p = paciente.get();
        List<Medico> doctors = new ArrayList<>();
        doctors.add(medicoRepository.findById(addMedicoDTO.medico_id()).get());
        p.setDoctors(doctors);
        //Paciente response = pacienteService.createPaciente(paciente);

        return ResponseEntity.ok(repository.save(p));
    }


}
