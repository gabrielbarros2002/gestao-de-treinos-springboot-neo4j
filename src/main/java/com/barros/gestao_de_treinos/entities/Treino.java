package com.barros.gestao_de_treinos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Node("Treino")
public class Treino implements Serializable {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;

    private String nome;

    @Relationship(type = "CONTÉM_EXERCICIO", direction = Relationship.Direction.OUTGOING)
    private List<TreinoExercicio> exercicios = new ArrayList<>();

    @Relationship(type = "ELABORA", direction = Relationship.Direction.INCOMING)
    private Usuario instrutor;

    public Treino() {
    }

    public Treino(String id, String nome, Usuario instrutor) {
        this.id = id;
        this.nome = nome;
        this.instrutor = instrutor;
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

    public List<TreinoExercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<TreinoExercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public Usuario getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Usuario instrutor) {
        this.instrutor = instrutor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Treino treino = (Treino) o;
        return Objects.equals(id, treino.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Treino{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", exercicios=" + exercicios +
                ", instrutor=" + instrutor +
                '}';
    }
}
