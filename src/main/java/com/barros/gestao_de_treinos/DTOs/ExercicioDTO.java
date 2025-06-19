package com.barros.gestao_de_treinos.DTOs;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class ExercicioDTO {

    private String id;
    private String nome;
    private String descricao;
    private String idGrupoMuscular;
    private String nomeGrupoMuscular;

    public ExercicioDTO() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
