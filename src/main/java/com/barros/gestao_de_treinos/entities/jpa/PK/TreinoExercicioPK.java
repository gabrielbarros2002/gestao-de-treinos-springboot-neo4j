package com.barros.gestao_de_treinos.entities.jpa.PK;

import com.barros.gestao_de_treinos.entities.jpa.Exercicio;
import com.barros.gestao_de_treinos.entities.jpa.Treino;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TreinoExercicioPK implements Serializable {

    @ManyToOne
    @JsonIgnoreProperties({"nome", "exercicios", "alunos", "instrutor"})
    @JoinColumn(name = "treino_id", foreignKey = @ForeignKey(name = "fk_treinoexercicio_treino"))
    private Treino treino;

    @ManyToOne
    @JoinColumn(name = "exercicio_id", foreignKey = @ForeignKey(name = "fk_treinoexercicio_exercicio"))
    private Exercicio exercicio;

    public TreinoExercicioPK() {
    }

    public TreinoExercicioPK(Treino treino, Exercicio exercicio) {
        this.treino = treino;
        this.exercicio = exercicio;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TreinoExercicioPK that = (TreinoExercicioPK) o;
        return Objects.equals(treino, that.treino) && Objects.equals(exercicio, that.exercicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treino, exercicio);
    }
}
