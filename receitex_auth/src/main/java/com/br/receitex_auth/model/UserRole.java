package com.br.receitex_auth.model;

public enum UserRole {
    PATIENT("patient"),
    DOCTOR("doctor"),

    PHARM("pharm");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
