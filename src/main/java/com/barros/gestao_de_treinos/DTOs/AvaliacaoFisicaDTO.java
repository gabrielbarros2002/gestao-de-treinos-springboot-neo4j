package com.barros.gestao_de_treinos.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class AvaliacaoFisicaDTO {

    private String id;

    @NotNull(message = "A data da avaliação é obrigatória")
    @PastOrPresent(message = "A data da avaliação não pode ser no futuro")
    private LocalDate data;

    @NotNull(message = "O peso é obrigatório")
    @Positive(message = "O peso deve ser maior que zero")
    private BigDecimal peso;

    @NotNull(message = "A altura é obrigatória")
    @Positive(message = "A altura deve ser maior que zero")
    private BigDecimal altura;

    @NotNull(message = "O IMC é obrigatório")
    @Positive(message = "O IMC deve ser maior que zero")
    private BigDecimal imc;

    @NotNull(message = "O percentual de gordura é obrigatório")
    @Positive(message = "O percentual de gordura deve ser maior que zero")
    private BigDecimal percentualGordura;

    @NotNull(message = "A massa muscular é obrigatória")
    @Positive(message = "A massa muscular deve ser maior que zero")
    private BigDecimal massaMuscularKg;

    @NotNull(message = "O id do instrutor avaliador é obrigatório")
    private String idInstrutor;

    private String nomeInstrutor;

    @NotNull(message = "O id do aluno avaliado é obrigatório")
    private String idAluno;

    private String nomeAluno;

    public AvaliacaoFisicaDTO() {
        iniciarAtributosEmBranco(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getImc() {
        return imc;
    }

    public void setImc(BigDecimal imc) {
        this.imc = imc;
    }

    public BigDecimal getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(BigDecimal percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public BigDecimal getMassaMuscularKg() {
        return massaMuscularKg;
    }

    public void setMassaMuscularKg(BigDecimal massaMuscularKg) {
        this.massaMuscularKg = massaMuscularKg;
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

    public String getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(String idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
}
