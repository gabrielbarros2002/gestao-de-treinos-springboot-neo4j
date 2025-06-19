package com.barros.gestao_de_treinos.entities.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "treinos")
public class Treino implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do treino é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre {min} e {max} caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotNull(message = "O treino deve conter exercícios")
    @OneToMany(mappedBy = "id.treino", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TreinoExercicio> exercicios;

    @JsonIgnore
    @ManyToMany(mappedBy = "treinos")
    private Set<Usuario> alunos = new HashSet<>();

    @NotNull(message = "O instrutor é obrigatório")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "instrutor_id", nullable = false, foreignKey = @ForeignKey(name = "fk_treino_instrutor"))
    private Usuario instrutor;

    public Treino() {
    }

    public Treino(Long id, String nome, Usuario instrutor) {
        this.id = id;
        this.nome = nome;
        this.exercicios = new HashSet<>();
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

    public Set<TreinoExercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(Set<TreinoExercicio> exercicios) {
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
