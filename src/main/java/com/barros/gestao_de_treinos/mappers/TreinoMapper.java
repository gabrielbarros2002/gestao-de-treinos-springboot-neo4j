package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.TreinoDTO;
import com.barros.gestao_de_treinos.entities.jpa.Treino;
import com.barros.gestao_de_treinos.entities.jpa.Usuario;

public class TreinoMapper {

    public static TreinoDTO toDTO(Treino entity) {
        TreinoDTO dto = new TreinoDTO();
        dto.setIdTreino(entity.getId());
        dto.setNomeTreino(entity.getNome());
        dto.setIdInstrutor(entity.getInstrutor().getId());
        dto.setNomeInstrutor(entity.getInstrutor().getNome());

        return dto;
    }

    public static Treino toEntity(TreinoDTO dto, Usuario instrutor) {
        Treino entity = new Treino();
        entity.setId(dto.getIdTreino());
        entity.setNome(dto.getNomeTreino());
        entity.setInstrutor(instrutor);

        return entity;
    }

}
