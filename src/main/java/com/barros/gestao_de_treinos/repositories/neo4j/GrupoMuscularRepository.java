package com.barros.gestao_de_treinos.repositories.neo4j;

import com.barros.gestao_de_treinos.entities.neo4j.GrupoMuscular;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface GrupoMuscularRepository extends Neo4jRepository<GrupoMuscular, Long> {
}
