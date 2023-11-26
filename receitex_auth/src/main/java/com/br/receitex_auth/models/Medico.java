package com.br.receitex_auth.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Set;

@Entity(name="medicos")
@DiscriminatorValue("medico")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medico extends UserBaseModel {

    //dono do relacionamento
    @ManyToMany(mappedBy = "doctors")
    @JsonManagedReference
    public Set<Paciente> patients;

    @Builder
    public Medico(String firstName, String lastName){
        this.firstName= firstName;
        this.lastName = lastName;
        this.role = UserRole.DOCTOR;
    }
}
