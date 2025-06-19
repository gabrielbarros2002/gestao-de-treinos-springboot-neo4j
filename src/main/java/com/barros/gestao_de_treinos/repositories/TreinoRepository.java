package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.jpa.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreinoRepository extends JpaRepository<Treino, Long> {

    List<Treino> findByAlunosId(Long alunoId);

}
