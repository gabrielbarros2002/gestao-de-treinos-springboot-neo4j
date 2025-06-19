package com.barros.gestao_de_treinos.repositories.neo4j;

import com.barros.gestao_de_treinos.entities.neo4j.Treino;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface TreinoNeo4jRepository extends Neo4jRepository<Treino, Long> {

    List<Treino> findByAlunosId(Long alunoId);

}
