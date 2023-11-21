package com.br.receitex_auth.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "pacientes")
@DiscriminatorValue("paciente")

public class Paciente extends UserBaseModel{
    @ManyToMany
    @JoinTable(name="medico_paciente",
            joinColumns={@JoinColumn(name="paciente_id")},
            inverseJoinColumns={@JoinColumn(name="medico_id")})
    List<Medico> doctors;

    @Builder
    public Paciente(){
        this.role = UserRole.PATIENT;
    }
    @Builder
    public Paciente(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = UserRole.PATIENT;
    }
}
