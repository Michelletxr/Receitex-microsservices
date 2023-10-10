package com.br.receitex.Repositories;

import com.br.receitex.models.Atestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtestadoRepository extends JpaRepository<Atestado, Long> {
}
