package com.barros.gestao_de_treinos.entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.io.Serializable;
import java.util.Objects;

@RelationshipProperties
public class TreinoExercicio implements Serializable {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;

    @TargetNode
    private Exercicio exercicio;

    private int series;
    private int repeticoes;
    private int ordem;

    public TreinoExercicio() {
    }

    public TreinoExercicio(Exercicio exercicio, int series, int repeticoes, int ordem) {
        this.exercicio = exercicio;
        this.series = series;
        this.repeticoes = repeticoes;
        this.ordem = ordem;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreinoExercicio that)) return false;
        return Objects.equals(exercicio, that.exercicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exercicio);
    }
}
