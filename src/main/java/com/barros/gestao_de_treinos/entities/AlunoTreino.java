package com.barros.gestao_de_treinos.entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.io.Serializable;
import java.util.Objects;

@RelationshipProperties
public class AlunoTreino implements Serializable {

    @Id
    @GeneratedValue
    private String id;

    private Integer quantExecucoes;

    @TargetNode
    private Treino treino;

    public AlunoTreino() {
    }

    public AlunoTreino(String id, Integer quantExecucoes, Treino treino) {
        this.id = id;
        this.quantExecucoes = quantExecucoes;
        this.treino = treino;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantExecucoes() {
        return quantExecucoes;
    }

    public void setQuantExecucoes(Integer quantExecucoes) {
        this.quantExecucoes = quantExecucoes;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AlunoTreino that = (AlunoTreino) o;
        return Objects.equals(treino, that.treino);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(treino);
    }
}
