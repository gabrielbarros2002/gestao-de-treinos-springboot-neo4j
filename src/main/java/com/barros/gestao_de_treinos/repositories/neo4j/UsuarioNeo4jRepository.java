package com.barros.gestao_de_treinos.repositories.neo4j;

import com.barros.gestao_de_treinos.entities.enums.Perfil;
import com.barros.gestao_de_treinos.entities.neo4j.Usuario;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioNeo4jRepository extends Neo4jRepository<Usuario, Long> {

    Optional<Usuario> findByEmailAndSenha(String email, String senha);

    List<Usuario> findByPerfil(Perfil perfil);

}
