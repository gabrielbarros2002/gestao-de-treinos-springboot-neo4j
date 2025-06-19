package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.entities.jpa.Treino;
import com.barros.gestao_de_treinos.entities.jpa.Usuario;
import com.barros.gestao_de_treinos.entities.enums.Perfil;
import com.barros.gestao_de_treinos.repositories.TreinoRepository;
import com.barros.gestao_de_treinos.repositories.UsuarioRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TreinoRepository treinoRepository;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario insert(Usuario obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Usuario update(Long id, Usuario obj) {
        try {
            Usuario entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar usuário: " + e.getMessage(), e);
        }
    }

    private void updateData(Usuario entity, Usuario obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setDataNascimento(obj.getDataNascimento());
        entity.setSenha(obj.getSenha());

        if (obj.getTreinos() == null) {
            obj.setTreinos(new HashSet<>());
        }
        List<Treino> treinosAtualizados = Optional.ofNullable(obj.getTreinos())
                .orElseThrow(() -> new RuntimeException("Treinos não foram enviados"))
                .stream()
                .map(t -> treinoRepository.findById(t.getId())
                        .orElseThrow(() -> new RuntimeException("Treino com ID " + t.getId() + " não encontrado")))
                .toList();

        entity.getTreinos().clear();
        entity.getTreinos().addAll(treinosAtualizados);
    }

    public Usuario autenticar(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha).orElse(null);
    }

    public List<Usuario> findAllAlunos() {
        return repository.findByPerfil(Perfil.ALUNO);
    }

    public List<Usuario> findAllInstrutores() {
        return repository.findByPerfil(Perfil.INSTRUTOR);
    }
}
