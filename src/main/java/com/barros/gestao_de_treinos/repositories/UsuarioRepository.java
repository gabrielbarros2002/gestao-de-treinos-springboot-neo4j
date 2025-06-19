package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.jpa.Usuario;
import com.barros.gestao_de_treinos.entities.enums.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmailAndSenha(String email, String senha);

    List<Usuario> findByPerfil(Perfil perfil);

}
