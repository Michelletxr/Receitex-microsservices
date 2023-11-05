package com.br.receitex_auth.controllers;

import com.br.receitex_auth.models.Medico;
import com.br.receitex_auth.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/get/{id}")
    public ResponseEntity<Medico> get(@PathVariable("id") UUID id) {
        Optional<Medico> p = medicoService.findOne(id);
        return ResponseEntity.of(p);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable("id") UUID id){
    Boolean b = medicoService.deleteEntity(id);

    if(!b){
        return new ResponseEntity<Boolean>(b, HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(b);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Medico> update(@RequestBody() Medico update, @PathVariable("id") UUID id) {
        Optional<Medico> p = medicoService.updateEntity(update, id);
        return ResponseEntity.of(p);
    }
}
