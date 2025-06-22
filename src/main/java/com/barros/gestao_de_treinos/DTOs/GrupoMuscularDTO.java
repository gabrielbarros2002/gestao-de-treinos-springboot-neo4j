package com.barros.gestao_de_treinos.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class GrupoMuscularDTO {

    private String idGrupoMuscular;

    @NotBlank(message = "O nome do grupo muscular é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre {min} e {max} caracteres")
    private String nomeGrupoMuscular;

    public GrupoMuscularDTO() {
        iniciarAtributosEmBranco(this);
    }

    public String getIdGrupoMuscular() {
        return idGrupoMuscular;
    }

    public void setIdGrupoMuscular(String idGrupoMuscular) {
        this.idGrupoMuscular = idGrupoMuscular;
    }

    public String getNomeGrupoMuscular() {
        return nomeGrupoMuscular;
    }

    public void setNomeGrupoMuscular(String nomeGrupoMuscular) {
        this.nomeGrupoMuscular = nomeGrupoMuscular;
    }
}
