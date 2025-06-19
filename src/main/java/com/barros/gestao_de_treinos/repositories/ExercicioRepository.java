package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.Exercicio;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ExercicioRepository extends Neo4jRepository<Exercicio, String> {
}
