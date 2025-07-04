package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.Usuario;
import com.barros.gestao_de_treinos.entities.enums.Perfil;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends Neo4jRepository<Usuario, String> {

    Optional<Usuario> findByEmailAndSenha(String email, String senha);

    List<Usuario> findByPerfil(Perfil perfil);

    @Query("""
        UNWIND $idsTreinos AS treinoId
        MATCH (t:Treino {id: treinoId})
        MATCH (u:Usuario {id: $idAluno})
                        MERGE (t)-[r:ATRIBUIDO_PARA]->(u)
                        SET r.quantExecucoes = 0
    """)
    void atribuirTreinosAoAluno(String idAluno, Collection<String> idsTreinos);

    @Query("""
        MATCH (t:Treino {id: $idTreino})
        MATCH (u:Usuario {id: $idAluno})
        MERGE (t)-[:ATRIBUIDO_PARA]->(u)
                        SET r.quantExecucoes = $quantExecucoes
    """)
    void atribuirTreinoAoAluno(String idAluno, String idTreino, Integer quantExecucoes);

    @Query("""
        MATCH (t:Treino {id: $idTreino})-[r:ATRIBUIDO_PARA]->(u:Usuario {id: $idAluno})
        DELETE r
    """)
    void removerTreinoDoAluno(String idAluno, String idTreino);

    @Query("""
        MATCH (t:Treino {id: $idTreino})-[r:ATRIBUIDO_PARA]->(u:Usuario {id: $idAluno})
        SET r.quantExecucoes = coalesce(r.quantExecucoes, 0) + 1
        RETURN r.quantExecucoes
    """)
    Integer contarExecucaoDeTreino(String idAluno, String idTreino);

}
