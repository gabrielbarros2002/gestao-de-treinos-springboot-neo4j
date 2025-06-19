package com.barros.gestao_de_treinos.repositories.neo4j;

import com.barros.gestao_de_treinos.entities.neo4j.GrupoMuscular;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface GrupoMuscularNeo4jRepository extends Neo4jRepository<GrupoMuscular, Long> {

    Optional<GrupoMuscular> findByNome(String nome);

}
