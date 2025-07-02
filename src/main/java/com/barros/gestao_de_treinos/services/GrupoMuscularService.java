package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.DTOs.GrupoMuscularDTO;
import com.barros.gestao_de_treinos.entities.GrupoMuscular;
import com.barros.gestao_de_treinos.mappers.GrupoMuscularMapper;
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

    public List<GrupoMuscularDTO> findAll() {
        List<GrupoMuscular> entityList = repository.findAll();
        return entityList.stream().map(GrupoMuscularMapper::toDTO).toList();
    }

    public GrupoMuscular findEntityById(String id) {
        Optional<GrupoMuscular> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public GrupoMuscularDTO findDtoById(String id) {
        GrupoMuscular entity = findEntityById(id);
        return GrupoMuscularMapper.toDTO(entity);
    }

    public GrupoMuscularDTO insert(GrupoMuscularDTO obj) {
        GrupoMuscular entity = GrupoMuscularMapper.toEntity(obj);
        entity.setId(null);
        GrupoMuscular saved = repository.save(entity);
        return GrupoMuscularMapper.toDTO(saved);
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

    public GrupoMuscularDTO update(String id, GrupoMuscularDTO obj) {
        GrupoMuscular entity = findEntityById(id);
        updateData(entity, obj);
        GrupoMuscular saved = repository.save(entity);
        return GrupoMuscularMapper.toDTO(saved);
    }

    private void updateData(GrupoMuscular entity, GrupoMuscularDTO obj) {
        entity.setNome(obj.getNome());
    }
}
