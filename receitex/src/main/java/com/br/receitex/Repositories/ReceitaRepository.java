package com.br.receitex.Repositories;

import com.br.receitex.models.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
