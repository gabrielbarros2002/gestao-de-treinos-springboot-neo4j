package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.AlunoTreinoDTO;
import com.barros.gestao_de_treinos.entities.AlunoTreino;
import com.barros.gestao_de_treinos.entities.Treino;

public class AlunoTreinoMapper {

    public static AlunoTreinoDTO toDTO(AlunoTreino entity) {
        if (entity == null) return null;

        AlunoTreinoDTO dto = new AlunoTreinoDTO();
        dto.setTreino(TreinoMapper.toDTO(entity.getTreino()));
        dto.setQuantExecucoes(entity.getQuantExecucoes());

        return dto;
    }

    public static AlunoTreino toEntity(AlunoTreinoDTO dto, Treino treino) {
        if (dto == null) return null;

        AlunoTreino entity = new AlunoTreino();
        entity.setId(null);
        entity.setQuantExecucoes(dto.getQuantExecucoes());
        entity.setTreino(treino);

        return entity;
    }
}
