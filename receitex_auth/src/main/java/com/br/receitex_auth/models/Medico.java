package com.br.receitex_auth.models;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity(name="medicos")
@DiscriminatorValue("medico")
public class Medico extends UserBaseModel {

    //pacientes
    @ManyToMany
    @JoinTable(name="MEDICO_PACIENTE",
            joinColumns={@JoinColumn(name="medico_id")},
            inverseJoinColumns={@JoinColumn(name="paciente_id")})
    private List<Paciente> patients;
    @Builder
    public Medico(){
        this.role = UserRole.DOCTOR;
    }
    @Builder
    public Medico(String firstName, String lastName){
        this.firstName= firstName;
        this.lastName = lastName;
        this.role = UserRole.DOCTOR;

    }
}
