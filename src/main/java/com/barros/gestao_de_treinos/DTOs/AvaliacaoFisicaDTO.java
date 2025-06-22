package com.barros.gestao_de_treinos.DTOs;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class AvaliacaoFisicaDTO {

    private String id;
    private LocalDate data;
    private BigDecimal peso;
    private BigDecimal altura;
    private BigDecimal imc;
    private BigDecimal percentualGordura;
    private BigDecimal massaMuscularKg;
    private String idInstrutor;
    private String nomeInstrutor;
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
