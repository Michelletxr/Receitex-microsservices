package com.br.receitex_auth.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name="medicos")
@DiscriminatorValue("medico")
public class Medico extends UserBaseModel {
    //private Number[] receitasIds;

    @Builder
    public Medico(){
        this.role = UserRole.DOCTOR;
    }
}
