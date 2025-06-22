package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.GrupoMuscularDTO;
import com.barros.gestao_de_treinos.entities.GrupoMuscular;

public class GrupoMuscularMapper {

    public static GrupoMuscularDTO toDTO(GrupoMuscular entity) {
        GrupoMuscularDTO dto = new GrupoMuscularDTO();
        dto.setIdGrupoMuscular(entity.getId());
        dto.setNomeGrupoMuscular(entity.getNome());

        return dto;
    }

    public static GrupoMuscular toEntity(GrupoMuscularDTO dto) {
        GrupoMuscular entity = new GrupoMuscular();
        entity.setId(dto.getIdGrupoMuscular());
        entity.setNome(dto.getNomeGrupoMuscular());

        return entity;
    }
}
