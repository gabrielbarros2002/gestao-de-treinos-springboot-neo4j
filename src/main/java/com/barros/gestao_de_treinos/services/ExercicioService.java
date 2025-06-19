package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.repositories.ExercicioRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository repository;

    public List<Exercicio> findAll() {
        return repository.findAll();
    }

    public Exercicio findById(String id) {
        Optional<Exercicio> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Exercicio insert(Exercicio obj) {
        return repository.save(obj);
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

    public Exercicio update(String id, Exercicio obj) {
        Exercicio entity = findById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Exercicio entity, Exercicio obj) {
        entity.setNome(obj.getNome());
        entity.setDescricao(obj.getDescricao());
        entity.setGrupoMuscular(obj.getGrupoMuscular());
    }
}
