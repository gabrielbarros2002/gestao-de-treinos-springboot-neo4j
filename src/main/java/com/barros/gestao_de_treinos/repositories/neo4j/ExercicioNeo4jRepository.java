package com.barros.gestao_de_treinos.repositories.neo4j;

import com.barros.gestao_de_treinos.entities.neo4j.Exercicio;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ExercicioNeo4jRepository extends Neo4jRepository<Exercicio, Long> {
}
