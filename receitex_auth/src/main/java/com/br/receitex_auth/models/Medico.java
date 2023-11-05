package com.br.receitex_auth.models;

import jakarta.persistence.*;
import lombok.Builder;

@Entity(name="medicos")
@DiscriminatorValue("medico")
public class Medico extends UserBaseModel {

    @Builder
    public Medico(){
        this.role = UserRole.DOCTOR;
    }
    @Builder
    public Medico(String firstName,String lastName){
        System.out.println("firstName = " + firstName + ", lastName = " + lastName);
        this.firstName=firstName;
        this.lastName = lastName;
        this.role = UserRole.DOCTOR;

    }
}
