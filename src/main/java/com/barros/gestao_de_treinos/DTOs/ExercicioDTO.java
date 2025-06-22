package com.barros.gestao_de_treinos.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class ExercicioDTO {

    private String idExercicio;

    @NotBlank(message = "O nome do exercício é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre {min} e {max} caracteres")
    private String nomeExercicio;

    @Size(max = 500, message = "A descrição não pode ultrapassar {max} caracteres")
    private String descricaoExercicio;

    @NotNull(message = "O grupo muscular é obrigatório")
    private String idGrupoMuscular;

    private String nomeGrupoMuscular;

    public ExercicioDTO() {
        iniciarAtributosEmBranco(this);
    }

    public String getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(String idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public String getDescricaoExercicio() {
        return descricaoExercicio;
    }

    public void setDescricaoExercicio(String descricaoExercicio) {
        this.descricaoExercicio = descricaoExercicio;
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
