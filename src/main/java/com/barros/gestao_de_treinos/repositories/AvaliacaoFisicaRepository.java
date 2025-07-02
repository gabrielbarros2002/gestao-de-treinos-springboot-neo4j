package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.AvaliacaoFisica;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface AvaliacaoFisicaRepository extends Neo4jRepository<AvaliacaoFisica, String> {

    @Query("""
        MATCH (a:Usuario {id: $idAluno})
        MATCH (i:Usuario {id: $idInstrutor})
        CREATE (af:AvaliacaoFisica {
            id: $id,
            data: date($data),
            peso: $peso,
            altura: $altura,
            imc: $imc,
            percentualGordura: $percentualGordura,
            massaMuscularKg: $massaMuscularKg
        })
        MERGE (af)-[:REALIZADA_POR_ALUNO]->(a)
        MERGE (af)-[:REALIZADA_POR_INSTRUTOR]->(i)
    """)
    void criarAvaliacaoFisicaComRelacionamentos(
            @Param("id") String id,
            @Param("data") LocalDate data,
            @Param("peso") BigDecimal peso,
            @Param("altura") BigDecimal altura,
            @Param("imc") BigDecimal imc,
            @Param("percentualGordura") BigDecimal percentualGordura,
            @Param("massaMuscularKg") BigDecimal massaMuscularKg,
            @Param("idAluno") String idAluno,
            @Param("idInstrutor") String idInstrutor
    );

    List<AvaliacaoFisica> findByAlunoId(String alunoId);

    List<AvaliacaoFisica> findByInstrutorId(String instrutorId);
}
