package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {

    List<AvaliacaoFisica> findByAlunoId(Long alunoId);

    List<AvaliacaoFisica> findByInstrutorId(Long instrutorId);

}
