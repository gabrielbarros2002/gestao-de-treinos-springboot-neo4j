package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.AvaliacaoFisica;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface AvaliacaoFisicaRepository extends Neo4jRepository<AvaliacaoFisica, String> {

    List<AvaliacaoFisica> findByAlunoId(Long alunoId);

    List<AvaliacaoFisica> findByInstrutorId(Long instrutorId);
}
