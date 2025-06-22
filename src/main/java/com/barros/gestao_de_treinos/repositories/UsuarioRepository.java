package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.enums.Perfil;
import com.barros.gestao_de_treinos.entities.Usuario;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends Neo4jRepository<Usuario, String> {

    Optional<Usuario> findByEmailAndSenha(String email, String senha);

    List<Usuario> findByPerfil(Perfil perfil);

}
