package com.barros.gestao_de_treinos.DTOs;

import java.util.List;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class TreinoDTO {

    private String idTreino;
    private String nomeTreino;
    private List<TreinoExercicioDTO> exercicios;
    private String idInstrutor;
    private String nomeInstrutor;

    public TreinoDTO() {
        iniciarAtributosEmBranco(this);
    }

    public String getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(String idTreino) {
        this.idTreino = idTreino;
    }

    public String getNomeTreino() {
        return nomeTreino;
    }

    public void setNomeTreino(String nomeTreino) {
        this.nomeTreino = nomeTreino;
    }

    public List<TreinoExercicioDTO> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<TreinoExercicioDTO> exercicios) {
        this.exercicios = exercicios;
    }

    public String getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(String idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }
}
