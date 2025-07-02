package com.barros.gestao_de_treinos.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class UsuarioDTO {

    private String id;

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

    @NotBlank(message = "O perfil é obrigatório")
    private String perfil;

    private Set<TreinoDTO> treinos = new HashSet<>();

    public UsuarioDTO() {
        iniciarAtributosEmBranco(this);
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Set<TreinoDTO> getTreinos() {
        return treinos;
    }

    public void setTreinos(Set<TreinoDTO> treinos) {
        this.treinos = treinos;
    }
}
