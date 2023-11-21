package com.br.receitex_auth.controllers;

import com.br.receitex_auth.models.Paciente;
import com.br.receitex_auth.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/paciente")
@RestController
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @PostMapping()
    public ResponseEntity<Paciente> createPaciente(@RequestBody PacienteService.PacienteRequestDTO paciente){
        Paciente response = pacienteService.createPaciente(paciente);
        return ResponseEntity.ok(response);
    }
    @GetMapping("")
    public ResponseEntity<List<Paciente>> listPacientes() {
        return ResponseEntity.of(Optional.ofNullable(pacienteService.getPacientes()));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Paciente> getPaciente(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(pacienteService.findOne(id).get());
    }




}
