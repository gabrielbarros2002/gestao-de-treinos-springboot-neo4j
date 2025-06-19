package com.barros.gestao_de_treinos.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class GrupoMuscularDTO {

    private String id;

    @NotBlank(message = "O nome do grupo muscular é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre {min} e {max} caracteres")
    private String nome;

    public GrupoMuscularDTO() {
        iniciarAtributosEmBranco(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
