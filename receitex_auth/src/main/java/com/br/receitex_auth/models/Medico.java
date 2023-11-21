package com.br.receitex_auth.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Entity(name="medicos")
@DiscriminatorValue("medico")
public class Medico extends UserBaseModel {

    //dono do relacionamento
    @ManyToMany(mappedBy = "doctors")
    List<Paciente> patients;

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
