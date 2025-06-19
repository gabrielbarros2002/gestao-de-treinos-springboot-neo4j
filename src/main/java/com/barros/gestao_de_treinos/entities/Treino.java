package com.barros.gestao_de_treinos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.io.Serializable;
import java.util.*;

@Node("Treino")
public class Treino implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "O nome do treino é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre {min} e {max} caracteres")
    private String nome;

    // Supondo que TreinoExercicio também será um @Node
    @NotNull(message = "O treino deve conter exercícios")
    @Relationship(type = "CONTÉM_EXERCICIO", direction = Relationship.Direction.OUTGOING)
    private List<TreinoExercicio> exercicios = new ArrayList<>();

    @JsonIgnore
    @Relationship(type = "ALUNO_TREINA", direction = Relationship.Direction.INCOMING)
    private Set<Usuario> alunos = new HashSet<>();

    @JsonIgnore
    @Relationship(type = "INSTRUI", direction = Relationship.Direction.INCOMING)
    private Usuario instrutor;

    public Treino() {
    }

    public Treino(Long id, String nome, Usuario instrutor) {
        this.id = id;
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<Usuario> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Usuario> alunos) {
        this.alunos = alunos;
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
                ", alunos=" + alunos +
                ", instrutor=" + instrutor +
                '}';
    }
}
