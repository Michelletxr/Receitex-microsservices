package com.br.receitex_auth.controllers;

import com.br.receitex_auth.models.Medico;
import com.br.receitex_auth.models.Paciente;
import com.br.receitex_auth.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/medico")
@RestController
public class MedicoController {

    @Autowired
    private MedicoService medicoService;
    @PostMapping()
    public ResponseEntity createMedico(@RequestBody MedicoService.MedicoRequestDTO medico){
        System.out.println("Teste");System.out.println(medico);

        Medico m = medicoService.createMedico(medico);
        return ResponseEntity.ok(m);
    }

    @GetMapping("")
    public ResponseEntity<List<Medico>> listDoctors() {
        return ResponseEntity.of(Optional.ofNullable(medicoService.getMedicos()));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Medico> get(@PathVariable("id") UUID id) {
        Optional<Medico> p = medicoService.findOne(id);
        return ResponseEntity.of(p);
    }

    @GetMapping("/listaPacientes/{id}")
    public ResponseEntity<List<Paciente>> listPatientsByDoctor(@PathVariable("id") UUID id) {
        Optional<Medico> p = medicoService.findOne(id);
        return ResponseEntity.of(Optional.ofNullable(p.get().getPatients()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable("id") UUID id){
    Boolean isDelet = medicoService.deleteEntity(id);

    if(!isDelet){
        return new ResponseEntity<Boolean>(isDelet, HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(isDelet);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Medico> update(@RequestBody() Medico update, @PathVariable("id") UUID id) {
        Optional<Medico> p = medicoService.updateEntity(update, id);
        return ResponseEntity.of(p);
    }

    @PutMapping(value = "addPaciente")
    public ResponseEntity<Medico> addPaciente(@RequestBody MedicoService.AddPacienteDTO addPacienteDTO ){
        return ResponseEntity.ok(medicoService.addPatient(addPacienteDTO));
    }
}
