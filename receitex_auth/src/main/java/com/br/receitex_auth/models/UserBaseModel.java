package com.br.receitex_auth.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

//@MappedSuperclass
@Data
@Entity(name="users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role_type", discriminatorType = DiscriminatorType.STRING)
public abstract class UserBaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String firstName;
    String lastName;
    UserRole role;

}
