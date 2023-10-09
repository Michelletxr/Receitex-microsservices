package com.br.receitex_auth.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.UUID;
@Entity
@NoArgsConstructor
@ToString(exclude = "password")
@Table(name = "user", schema = "public")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String userName;
    String password;
    @Builder
    public User(UUID id, String userName, String password){

    }
}
