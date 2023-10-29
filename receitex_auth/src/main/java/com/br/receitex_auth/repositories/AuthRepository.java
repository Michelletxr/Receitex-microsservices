package com.br.receitex_auth.repositories;

import com.br.receitex_auth.models.AuthModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface AuthRepository extends JpaRepository<AuthModel, UUID> {
    UserDetails findByUserName(String username);
}
