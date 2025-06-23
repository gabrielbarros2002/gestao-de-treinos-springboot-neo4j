package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.DTOs.ExercicioDTO;
import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.mappers.ExercicioMapper;
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

    @Autowired
    private GrupoMuscularService grupoMuscularService;

    public List<ExercicioDTO> findAll() {
        List<Exercicio> entityList = repository.findAll();
        return entityList.stream().map(ExercicioMapper::toDTO).toList();
    }

    public Exercicio findEntityById(String id) {
        Optional<Exercicio> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ExercicioDTO findDtoById(String id) {
        Exercicio entity = findEntityById(id);
        return ExercicioMapper.toDTO(entity);
    }

    public ExercicioDTO insert(ExercicioDTO obj) {
        Exercicio entity = ExercicioMapper.toEntity(obj);
        entity.setId(null);
        Exercicio saved = repository.save(entity);
        return ExercicioMapper.toDTO(saved);
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

    public ExercicioDTO update(String id, ExercicioDTO obj) {
        Exercicio entity = findEntityById(id);
        updateData(entity, obj);
        repository.save(entity);
        return ExercicioMapper.toDTO(entity);
    }

    private void updateData(Exercicio entity, ExercicioDTO obj) {
        entity.setNome(obj.getNomeExercicio());
        entity.setDescricao(obj.getDescricaoExercicio());
        entity.setGrupoMuscular(grupoMuscularService.findEntityById(obj.getIdGrupoMuscular()));
    }
}
