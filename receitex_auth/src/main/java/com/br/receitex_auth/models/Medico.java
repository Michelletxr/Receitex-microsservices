package com.br.receitex_auth.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class Medico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Number[] receitasIds;


    public Medico(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Number[] getReceitasIds() {
        return receitasIds;
    }

    public void setReceitasIds(Number[] receitasIds) {
        this.receitasIds = receitasIds;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
