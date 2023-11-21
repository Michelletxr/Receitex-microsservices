package com.br.receitex_auth.controllers;

import com.br.receitex_auth.models.Paciente;
import com.br.receitex_auth.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/paciente")
@RestController
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @PostMapping()
    public ResponseEntity createPaciente(@RequestBody PacienteService.PacienteRequestDTO paciente){

        Paciente response = pacienteService.createPaciente(paciente);
        return ResponseEntity.ok(response);
    }
}
