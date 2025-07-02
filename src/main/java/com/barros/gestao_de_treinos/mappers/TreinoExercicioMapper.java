package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.TreinoExercicioDTO;
import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.entities.TreinoExercicio;

public class TreinoExercicioMapper {

    public static TreinoExercicioDTO toDTO(TreinoExercicio entity) {
        TreinoExercicioDTO dto = new TreinoExercicioDTO();
        dto.setIdExercicio(entity.getExercicio().getId());
        dto.setNomeExercicio(entity.getExercicio().getNome());
        dto.setNomeGrupoMuscular(entity.getExercicio().getGrupoMuscular().getNome());
        dto.setSeries(entity.getSeries());
        dto.setRepeticoes(entity.getRepeticoes());
        dto.setOrdem(entity.getOrdem());

        return dto;
    }

    public static TreinoExercicio toEntity(TreinoExercicioDTO dto, Exercicio exercicio) {
        TreinoExercicio entity = new TreinoExercicio();
        entity.setId(null);
        entity.setExercicio(exercicio);
        entity.setSeries(dto.getSeries());
        entity.setRepeticoes(dto.getRepeticoes());
        entity.setOrdem(dto.getOrdem());

        return entity;
    }

}
