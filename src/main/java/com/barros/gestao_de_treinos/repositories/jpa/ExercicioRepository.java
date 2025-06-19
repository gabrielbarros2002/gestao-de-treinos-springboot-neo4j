package com.barros.gestao_de_treinos.repositories.jpa;

import com.barros.gestao_de_treinos.entities.jpa.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
}
