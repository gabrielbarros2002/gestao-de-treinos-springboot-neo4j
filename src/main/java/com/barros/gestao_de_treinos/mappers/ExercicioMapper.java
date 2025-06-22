package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.ExercicioDTO;
import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.entities.GrupoMuscular;

public class ExercicioMapper {

    public static ExercicioDTO toDTO(Exercicio entity) {
        ExercicioDTO dto = new ExercicioDTO();
        dto.setIdExercicio(entity.getId());
        dto.setNomeExercicio(entity.getNome());
        dto.setDescricaoExercicio(entity.getDescricao());
        dto.setIdGrupoMuscular(entity.getGrupoMuscular().getId());
        dto.setNomeGrupoMuscular(entity.getGrupoMuscular().getNome());

        return dto;
    }

    public static Exercicio toEntity(ExercicioDTO dto) {
        Exercicio entity = new Exercicio();
        entity.setId(dto.getIdExercicio());
        entity.setNome(dto.getNomeExercicio());
        entity.setDescricao(dto.getDescricaoExercicio());
        entity.setGrupoMuscular(new GrupoMuscular(dto.getIdGrupoMuscular(), dto.getNomeGrupoMuscular()));

        return entity;
    }
}
