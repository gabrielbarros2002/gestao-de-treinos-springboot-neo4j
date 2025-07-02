package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.DTOs.TreinoDTO;
import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.entities.Treino;
import com.barros.gestao_de_treinos.entities.TreinoExercicio;
import com.barros.gestao_de_treinos.entities.Usuario;
import com.barros.gestao_de_treinos.mappers.TreinoExercicioMapper;
import com.barros.gestao_de_treinos.mappers.TreinoMapper;
import com.barros.gestao_de_treinos.repositories.TreinoRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository repository;

    @Autowired
    @Lazy
    private UsuarioService usuarioService;

    @Autowired
    private ExercicioService exercicioService;

    @Autowired
    private GrupoMuscularService grupoMuscularService;

    public List<TreinoDTO> findAll() {
        List<Treino> entityList = repository.findAll();
        return entityList.stream().map(TreinoMapper::toDTO).toList();
    }

    public Treino findEntityById(String id) {
        Optional<Treino> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public TreinoDTO findDtoById(String id) {
        Treino entity = findEntityById(id);
        return TreinoMapper.toDTO(entity);
    }

    public TreinoDTO insert(TreinoDTO obj) {
        Usuario instrutor = usuarioService.findEntityById(obj.getIdInstrutor());
        Treino entity = TreinoMapper.toEntity(obj, instrutor);
        entity.setId(null);
        Treino saved = repository.save(entity);
        return TreinoMapper.toDTO(saved);
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

    public TreinoDTO update(String id, TreinoDTO obj) {
        Treino entity = findEntityById(id);
        updateData(entity, obj);
        repository.save(entity);
        return TreinoMapper.toDTO(entity);
    }

    private void updateData(Treino entity, TreinoDTO dto) {
        entity.setNome(dto.getNome());

        if (dto.getIdInstrutor() != null) {
            Usuario instrutor = usuarioService.findEntityById(dto.getIdInstrutor());
            entity.setInstrutor(instrutor);
        }

        List<TreinoExercicio> novosExercicios = Optional.ofNullable(dto.getExercicios())
                .orElseThrow(() -> new RuntimeException("Exercícios não foram enviados"))
                .stream()
                .map(teDto -> {
                    Exercicio exercicio = exercicioService.findEntityById(teDto.getIdExercicio());
                    return TreinoExercicioMapper.toEntity(teDto, exercicio);
                })
                .collect(Collectors.toList());

        entity.setExercicios(novosExercicios);
    }

    public List<TreinoDTO> buscarTreinosPorAluno(String alunoId) {
        List<Treino> entityList = repository.buscarTreinosPorIdAluno(alunoId);

        return entityList.stream()
                .map(treino -> TreinoMapper.toDTO(repository.findById(treino.getId()).orElseThrow()))
                .toList();
    }

}
