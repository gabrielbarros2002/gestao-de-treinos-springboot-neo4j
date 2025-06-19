package com.barros.gestao_de_treinos.repositories.neo4j;

import com.barros.gestao_de_treinos.entities.neo4j.AvaliacaoFisica;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface AvaliacaoFisicaNeo4jRepository extends Neo4jRepository<AvaliacaoFisica, Long> {

    List<AvaliacaoFisica> findByAlunoId(Long alunoId);

    List<AvaliacaoFisica> findByInstrutorId(Long instrutorId);
}
