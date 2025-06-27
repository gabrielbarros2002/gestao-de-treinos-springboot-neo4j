package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.enums.Perfil;
import com.barros.gestao_de_treinos.entities.Usuario;
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
        MERGE (t)-[:ATRIBUIDO_PARA]->(u)
    """)
    void atribuirTreinosAoAluno(String idAluno, Collection<String> idsTreinos);


}
