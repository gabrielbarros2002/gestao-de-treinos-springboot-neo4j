package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.Treino;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TreinoRepository extends Neo4jRepository<Treino, String> {

    @Query("""
        MATCH (t:Treino)-[:ATRIBUIDO_PARA]->(u:Usuario {id: $idAluno})
        RETURN t
    """)
    List<Treino> buscarTreinosPorIdAluno(@Param("idAluno") String idAluno);


}
