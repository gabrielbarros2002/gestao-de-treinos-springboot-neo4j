package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.Treino;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface TreinoRepository extends Neo4jRepository<Treino, String> {

    List<Treino> findByAlunosId(Long alunoId);

}
