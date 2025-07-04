package com.barros.gestao_de_treinos.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class TreinoDTO {

    private String id;

    @NotBlank(message = "O nome do treino é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre {min} e {max} caracteres")
    private String nome;

    @NotNull(message = "O treino deve conter exercícios")
    private List<TreinoExercicioDTO> exercicios;

    @NotNull(message = "O id do instrutor é obrigatório")
    private String idInstrutor;

    private String nomeInstrutor;

    public TreinoDTO() {
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
