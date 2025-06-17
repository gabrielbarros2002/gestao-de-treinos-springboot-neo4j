package com.barros.gestao_de_treinos.entities;

import com.barros.gestao_de_treinos.entities.PK.TreinoExercicioPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "treino_exercicios")
public class TreinoExercicio implements Serializable {

    @EmbeddedId
    private TreinoExercicioPK id;

    @NotNull(message = "O número de séries é obrigatório")
    @Min(value = 1, message = "Deve ter pelo menos 1 série")
    @Column(nullable = false)
    private Integer series;

    @NotNull(message = "O número de repetições é obrigatório")
    @Min(value = 1, message = "Deve ter pelo menos 1 repetição")
    @Column(nullable = false)
    private Integer repeticoes;

    public TreinoExercicio() {
        this.id = new TreinoExercicioPK();
    }

    public TreinoExercicio(Treino treino, Exercicio exercicio, Integer series, Integer repeticoes) {
        this.id = new TreinoExercicioPK(treino, exercicio);
        this.series = series;
        this.repeticoes = repeticoes;
    }

    @JsonIgnore
    public TreinoExercicioPK getId() {
        return id;
    }

    public void setId(TreinoExercicioPK id) {
        this.id = id;
    }

    @JsonIgnoreProperties({"nome", "exercicios", "alunos", "instrutor"})
    public Treino getTreino() {
        return id.getTreino();
    }

    public void setTreino(Treino treino) {
        id.setTreino(treino);
    }

    public Exercicio getExercicio() {
        return id.getExercicio();
    }

    public void setExercicio(Exercicio exercicio) {
        id.setExercicio(exercicio);
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TreinoExercicio that = (TreinoExercicio) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
