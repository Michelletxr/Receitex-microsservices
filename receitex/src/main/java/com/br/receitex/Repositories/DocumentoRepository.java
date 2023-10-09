package com.br.receitex.Repositories;

import com.br.receitex.models.Documento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentoRepository extends CrudRepository<Documento, Long> {


}
