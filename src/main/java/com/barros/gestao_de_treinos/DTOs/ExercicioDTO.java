package com.barros.gestao_de_treinos.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class ExercicioDTO {

    private String id;

    @NotBlank(message = "O nome do exercício é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre {min} e {max} caracteres")
    private String nome;

    @Size(max = 500, message = "A descrição não pode ultrapassar {max} caracteres")
    private String descricao;

    @NotNull(message = "O grupo muscular é obrigatório")
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
