package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.TreinoExercicioDTO;
import com.barros.gestao_de_treinos.entities.jpa.Exercicio;
import com.barros.gestao_de_treinos.entities.jpa.PK.TreinoExercicioPK;
import com.barros.gestao_de_treinos.entities.jpa.Treino;
import com.barros.gestao_de_treinos.entities.jpa.TreinoExercicio;

public class TreinoExercicioMapper {

    public static TreinoExercicioDTO toDTO(TreinoExercicio entity) {
        TreinoExercicioDTO dto = new TreinoExercicioDTO();
        dto.setIdTreino(entity.getTreino().getId());
        dto.setIdExercicio(entity.getExercicio().getId());
        dto.setNomeExercicio(entity.getExercicio().getNome());
        dto.setNomeGrupoMuscular(entity.getExercicio().getGrupoMuscular().getNome());
        dto.setSeries(entity.getSeries());
        dto.setRepeticoes(entity.getRepeticoes());

        return dto;
    }

    public static TreinoExercicio toEntity(TreinoExercicioDTO dto, Treino treino, Exercicio exercicio) {
        TreinoExercicio entity = new TreinoExercicio();
        TreinoExercicioPK pk = new TreinoExercicioPK();

        pk.setTreino(treino);
        pk.setExercicio(exercicio);
        entity.setId(pk);

        entity.setSeries(dto.getSeries());
        entity.setRepeticoes(dto.getRepeticoes());

        return entity;
    }

}
