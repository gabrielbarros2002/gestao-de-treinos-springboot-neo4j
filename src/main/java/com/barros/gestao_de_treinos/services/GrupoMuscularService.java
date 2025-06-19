package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.entities.GrupoMuscular;
import com.barros.gestao_de_treinos.repositories.GrupoMuscularRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoMuscularService {

    @Autowired
    private GrupoMuscularRepository repository;

    public List<GrupoMuscular> findAll() {
        return repository.findAll();
    }

    public GrupoMuscular findById(String id) {
        Optional<GrupoMuscular> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public GrupoMuscular insert(GrupoMuscular obj) {
        System.out.println("Tentando salvar: " + obj);
        System.out.println("Repository class: " + repository.getClass());

        GrupoMuscular saved = repository.save(obj);
        System.out.println("Salvo com sucesso: " + saved);
        return saved;
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

    public GrupoMuscular update(String id, GrupoMuscular obj) {
        GrupoMuscular entity = findById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(GrupoMuscular entity, GrupoMuscular obj) {
        entity.setNome(obj.getNome());
    }
}
