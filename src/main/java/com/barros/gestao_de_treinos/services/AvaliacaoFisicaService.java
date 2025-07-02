package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.DTOs.AvaliacaoFisicaDTO;
import com.barros.gestao_de_treinos.entities.AvaliacaoFisica;
import com.barros.gestao_de_treinos.mappers.AvaliacaoFisicaMapper;
import com.barros.gestao_de_treinos.repositories.AvaliacaoFisicaRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository repository;

    public List<AvaliacaoFisicaDTO> findAll() {
        List<AvaliacaoFisica> entityList = repository.findAll();
        return entityList.stream().map(AvaliacaoFisicaMapper::toDTO).toList();
    }

    public AvaliacaoFisica findEntityById(String id) {
        Optional<AvaliacaoFisica> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public AvaliacaoFisicaDTO findDtoById(String id) {
        AvaliacaoFisica entity = findEntityById(id);
        return AvaliacaoFisicaMapper.toDTO(entity);
    }

    public AvaliacaoFisicaDTO insert(AvaliacaoFisicaDTO obj) {
        AvaliacaoFisica entity = AvaliacaoFisicaMapper.toEntity(obj);
        entity.setId(UUID.randomUUID().toString());
        repository.criarAvaliacaoFisicaComRelacionamentos(
                entity.getId(),
                entity.getData(),
                entity.getPeso(),
                entity.getAltura(),
                entity.getImc(),
                entity.getPercentualGordura(),
                entity.getMassaMuscularKg(),
                entity.getAluno().getId(),
                entity.getInstrutor().getId()
        );
        return AvaliacaoFisicaMapper.toDTO(entity);
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

    public AvaliacaoFisicaDTO update(String id, AvaliacaoFisicaDTO obj) {
        AvaliacaoFisica entity = findEntityById(id);
        updateData(entity, obj);
        AvaliacaoFisica saved = repository.save(entity);
        return AvaliacaoFisicaMapper.toDTO(saved);
    }

    private void updateData(AvaliacaoFisica entity, AvaliacaoFisicaDTO obj) {
        entity.setData(obj.getData());
        entity.setAltura(obj.getAltura());
        entity.setPeso(obj.getPeso());
        entity.calcularIMC();
        entity.setPercentualGordura(obj.getPercentualGordura());
        entity.setMassaMuscularKg(obj.getMassaMuscularKg());
        entity.setIdAluno(obj.getIdAluno());
        entity.setIdInstrutor(obj.getIdInstrutor());
    }

    public List<AvaliacaoFisicaDTO> buscarAvaliacoesPorAluno(String alunoId) {
        List<AvaliacaoFisica> entityList = repository.findByAlunoId(alunoId);
        return entityList.stream().map(AvaliacaoFisicaMapper::toDTO).toList();
    }

    public List<AvaliacaoFisicaDTO> buscarAvaliacoesPorInstrutor(String instrutorId) {
        List<AvaliacaoFisica> entityList = repository.findByInstrutorId(instrutorId);
        return entityList.stream().map(AvaliacaoFisicaMapper::toDTO).toList();
    }
}
