package com.br.receitex_auth.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity(name = "pacientes")
@DiscriminatorValue("paciente")
public class Paciente extends UserBaseModel{

    @Builder
    public Paciente(){
        this.role = UserRole.PATIENT;
    }
}
