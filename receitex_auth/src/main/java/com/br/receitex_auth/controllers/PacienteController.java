package com.br.receitex_auth.controllers;

import com.br.receitex_auth.models.Medico;
import com.br.receitex_auth.models.Paciente;
import com.br.receitex_auth.service.MedicoService;
import com.br.receitex_auth.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
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
    public ResponseEntity<List<PacienteService.PacienteResponseDTO>> listPacientes() {
        List<Paciente> pacienteList = pacienteService.getPacientes();
        return ResponseEntity.ok(pacienteList.stream()
                .map(p -> pacienteService.buildPacienteToPacienteDTO(p)).toList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PacienteService.PacienteResponseDTO> getPaciente(@PathVariable("id") UUID id) {
        Paciente p = pacienteService.findOne(id).get();
        return ResponseEntity.ok(pacienteService.buildPacienteToPacienteDTO(p));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable("id") UUID id){
        Boolean isDelet = pacienteService.deleteEntity(id);
        if(!isDelet){
            return new ResponseEntity<Boolean>(isDelet, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(isDelet);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PacienteService.PacienteResponseDTO> update(@RequestBody() Paciente update,
                                                                  @PathVariable("id") UUID id) {
        Paciente p = pacienteService.updateEntity(update, id);
        if(Objects.isNull(p)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(pacienteService.buildPacienteToPacienteDTO(p));
    }




}
