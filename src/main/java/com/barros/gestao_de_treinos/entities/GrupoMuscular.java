package com.barros.gestao_de_treinos.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.io.Serializable;
import java.util.Objects;

@Node("GrupoMuscular")
public class GrupoMuscular implements Serializable {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;

    private String nome;

    public GrupoMuscular() {}

    public GrupoMuscular(String id, String nome) {
        this.id = id;
        this.nome = nome;
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
