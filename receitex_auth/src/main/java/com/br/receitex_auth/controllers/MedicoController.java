package com.br.receitex_auth.controllers;

import com.br.receitex_auth.models.Medico;
import com.br.receitex_auth.models.Paciente;
import com.br.receitex_auth.service.MedicoService;
import com.br.receitex_auth.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/medico")
@RestController
public class MedicoController {

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<MedicoService.MedicoResponseDTO> createMedico(
            @RequestBody MedicoService.MedicoRequestDTO medico){

        Medico m = medicoService.createMedico(medico);
        return ResponseEntity.ok(medicoService.buildMedicoToMedicoDTO(m));
    }

    @GetMapping("")
    public ResponseEntity<List<MedicoService.MedicoResponseDTO>> listDoctors() {
        List<Medico> medicoList = medicoService.getMedicos();
        return ResponseEntity.ok(medicoList.stream().map(m -> medicoService.buildMedicoToMedicoDTO(m)).toList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MedicoService.MedicoResponseDTO> get(@PathVariable("id") UUID id) {
        Medico m = medicoService.findOne(id).get();
        return ResponseEntity.ok(medicoService.buildMedicoToMedicoDTO(m));
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/listaPacientes/{id}")
    public ResponseEntity<List<PacienteService.PacienteResponseDTO>> listPatientsByDoctor(@PathVariable("id") UUID id) {
        Medico m = medicoService.findOne(id).get();
        List<Paciente> pacienteList = m.getPatients().stream().toList();
        return ResponseEntity.ok(pacienteList.stream()
                .map(p -> pacienteService.buildPacienteToPacienteDTO(p)).toList());
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
    public ResponseEntity<MedicoService.MedicoResponseDTO> update(@RequestBody() Medico update,
                                                                  @PathVariable("id") UUID id) {
        Medico m = medicoService.updateEntity(update, id);
        if(Objects.isNull(m)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(medicoService.buildMedicoToMedicoDTO(m));
    }

    @PutMapping(value = "/addPaciente")
    public ResponseEntity<Paciente> addPaciente(@RequestBody MedicoService.AddPacienteDTO addPacienteDTO ){
        Paciente patientResult = medicoService.adicionarPacienteAoMedico(addPacienteDTO.medico_id(),
                addPacienteDTO.paciente_id());
        return ResponseEntity.ok(patientResult);
    }
}
