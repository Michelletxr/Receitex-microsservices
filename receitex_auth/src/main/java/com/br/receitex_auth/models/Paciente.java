package com.br.receitex_auth.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "pacientes")
@DiscriminatorValue("paciente")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente extends UserBaseModel{
    @ManyToMany()
    @JoinTable(name="medico_paciente",
            joinColumns={@JoinColumn(name="paciente_id")},
            inverseJoinColumns={@JoinColumn(name="medico_id")})
    @JsonBackReference
    public Set<Medico> doctors;

    @Builder
    public Paciente(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = UserRole.PATIENT;
    }
}
