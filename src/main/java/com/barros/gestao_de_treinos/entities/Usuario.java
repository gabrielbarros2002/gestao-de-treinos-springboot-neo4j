package com.barros.gestao_de_treinos.entities;

import com.barros.gestao_de_treinos.entities.enums.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Node("Usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre {min} e {max} caracteres")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Por favor, forneça um endereço de email válido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 5, message = "A senha deve ter no mínimo {min} caracteres")
    private String senha;

    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @NotNull(message = "O perfil é obrigatório")
    private Perfil perfil;

    @Relationship(type = "ALUNO_TREINA", direction = Relationship.Direction.OUTGOING)
    private Set<Treino> treinos = new HashSet<>();

    @Relationship(type = "INSTRUI", direction = Relationship.Direction.OUTGOING)
    private Set<Treino> treinosInstrutor = new HashSet<>();

    public Usuario() {}

    public Usuario(Long id, String nome, String email, String senha, LocalDate dataNascimento, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.perfil = perfil;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Set<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(Set<Treino> treinos) {
        this.treinos = treinos;
    }

    public void addTreino(Treino treino) {
        this.treinos.add(treino);
    }

    public Set<Treino> getTreinosInstrutor() {
        return treinosInstrutor;
    }

    public void setTreinosInstrutor(Set<Treino> treinosInstrutor) {
        this.treinosInstrutor = treinosInstrutor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getId(), usuario.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", perfil=" + perfil +
                ", treinos=" + treinos +
                '}';
    }
}
