package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.GrupoMuscular;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface GrupoMuscularRepository extends Neo4jRepository<GrupoMuscular, String> {

    Optional<GrupoMuscular> findByNome(String nome);

}
