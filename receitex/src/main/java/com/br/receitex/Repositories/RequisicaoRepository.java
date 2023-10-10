package com.br.receitex.Repositories;

import com.br.receitex.models.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoRepository extends JpaRepository<Requisicao, Long> {
}
