package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.AvaliacaoFisicaDTO;
import com.barros.gestao_de_treinos.entities.AvaliacaoFisica;
import com.barros.gestao_de_treinos.entities.Usuario;

public class AvaliacaoFisicaMapper {

    public static AvaliacaoFisicaDTO toDTO(AvaliacaoFisica entity) {
        AvaliacaoFisicaDTO dto = new AvaliacaoFisicaDTO();
        dto.setIdAvaliacao(entity.getId());
        dto.setDataAvaliacao(entity.getData());
        dto.setPeso(entity.getPeso());
        dto.setAltura(entity.getAltura());
        dto.setPercentualGordura(entity.getPercentualGordura());
        dto.setMassaMuscularKg(entity.getMassaMuscularKg());

        dto.setIdAluno(entity.getAluno().getId());
        dto.setNomeAluno(entity.getAluno().getNome());

        dto.setIdInstrutor(entity.getInstrutor().getId());
        dto.setNomeInstrutor(entity.getInstrutor().getNome());

        return dto;
    }

    public static AvaliacaoFisica toEntity(AvaliacaoFisicaDTO dto) {
        AvaliacaoFisica entity = new AvaliacaoFisica();
        entity.setId(dto.getIdAvaliacao());
        entity.setData(dto.getDataAvaliacao());
        entity.setPeso(dto.getPeso());
        entity.setAltura(dto.getAltura());
        entity.setPercentualGordura(dto.getPercentualGordura());
        entity.setMassaMuscularKg(dto.getMassaMuscularKg());

        entity.setAluno(new Usuario());
        entity.getAluno().setId(dto.getIdAluno());
        entity.getAluno().setNome(dto.getNomeAluno());

        entity.setInstrutor(new Usuario());
        entity.getInstrutor().setId(dto.getIdInstrutor());
        entity.getInstrutor().setNome(dto.getNomeInstrutor());

        return entity;
    }
}
