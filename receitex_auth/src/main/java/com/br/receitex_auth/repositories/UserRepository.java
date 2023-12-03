package com.br.receitex_auth.repositories;

import com.br.receitex_auth.models.UserBaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository  extends JpaRepository<UserBaseModel, UUID> {
}
