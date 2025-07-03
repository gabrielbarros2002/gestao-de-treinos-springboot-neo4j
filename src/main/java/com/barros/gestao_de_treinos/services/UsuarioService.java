package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.DTOs.UsuarioDTO;
import com.barros.gestao_de_treinos.entities.Usuario;
import com.barros.gestao_de_treinos.entities.enums.Perfil;
import com.barros.gestao_de_treinos.mappers.UsuarioMapper;
import com.barros.gestao_de_treinos.repositories.TreinoRepository;
import com.barros.gestao_de_treinos.repositories.UsuarioRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TreinoRepository treinoRepository;

    public List<UsuarioDTO> findAll() {
        List<Usuario> entityList =  repository.findAll();
        return entityList.stream().map(UsuarioMapper::toDTO).toList();
    }

    public Usuario findEntityById(String id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public UsuarioDTO findDtoById(String id) {
        Usuario entity = findEntityById(id);
        return UsuarioMapper.toDTO(entity);
    }

    public UsuarioDTO insert(UsuarioDTO obj) {
        Usuario entity = UsuarioMapper.toEntity(obj);
        entity.setId(null);
        repository.save(entity);
        return UsuarioMapper.toDTO(entity);
    }

    public void delete(String id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public UsuarioDTO update(String id, UsuarioDTO obj) {
        Usuario entity = findEntityById(id);
        updateData(entity, obj);
        Usuario saved = repository.save(entity);
        return UsuarioMapper.toDTO(saved);
    }

    private void updateData(Usuario entity, UsuarioDTO obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setDataNascimento(obj.getDataNascimento());
        entity.setSenha(obj.getSenha());
        entity.setTreinos(null);
    }

    public UsuarioDTO autenticar(String email, String senha) {
        Usuario entity = repository.findByEmailAndSenha(email, senha).orElse(null);
        return UsuarioMapper.toDTO(entity);
    }

    public List<UsuarioDTO> findAllAlunos() {
        List<Usuario> entityList = repository.findByPerfil(Perfil.ALUNO);
        return entityList.stream().map(UsuarioMapper::toDTO).toList();
    }

    public List<UsuarioDTO> findAllInstrutores() {
        List<Usuario> entityList = repository.findByPerfil(Perfil.INSTRUTOR);
        return entityList.stream().map(UsuarioMapper::toDTO).toList();
    }

    public void atribuirTreinoAoAluno(String idAluno, String idTreino) {
        repository.atribuirTreinoAoAluno(idAluno, idTreino);
    }

    public void removerTreinoDoAluno(String idAluno, String idTreino) {
        repository.removerTreinoDoAluno(idAluno, idTreino);
    }
}
