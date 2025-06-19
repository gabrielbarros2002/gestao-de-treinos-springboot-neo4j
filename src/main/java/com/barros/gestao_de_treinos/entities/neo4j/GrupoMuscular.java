package com.barros.gestao_de_treinos.entities.neo4j;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Node("GrupoMuscular")
public class GrupoMuscular implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "O nome do grupo muscular é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre {min} e {max} caracteres")
    private String nome;

    @JsonIgnore
    @Relationship(type = "PERTENCE_A", direction = Relationship.Direction.INCOMING)
    private List<Exercicio> exercicios;

    public GrupoMuscular() {}

    public GrupoMuscular(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GrupoMuscular that = (GrupoMuscular) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "GrupoMuscular{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
