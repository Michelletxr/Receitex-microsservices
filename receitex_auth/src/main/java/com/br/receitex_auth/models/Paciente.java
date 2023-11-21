package com.br.receitex_auth.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Builder;

import java.util.List;

@Entity(name = "pacientes")
@DiscriminatorValue("paciente")
public class Paciente extends UserBaseModel{
    @ManyToMany(mappedBy = "patients")
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
