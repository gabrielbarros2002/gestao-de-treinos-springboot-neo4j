package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.DTOs.ExercicioDTO;
import com.barros.gestao_de_treinos.services.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/exercicio")
public class ExercicioResource {

    @Autowired
    private ExercicioService service;

    @GetMapping
    public ResponseEntity<List<ExercicioDTO>> findAll() {
        List<ExercicioDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExercicioDTO> findById(@PathVariable String id) {
        ExercicioDTO obj = service.findDtoById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<ExercicioDTO> insert(@RequestBody ExercicioDTO obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdExercicio()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ExercicioDTO> update(@PathVariable String id, @RequestBody ExercicioDTO obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
