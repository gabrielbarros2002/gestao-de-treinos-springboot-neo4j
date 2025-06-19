package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.entities.GrupoMuscular;
import com.barros.gestao_de_treinos.services.GrupoMuscularService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/grupo-muscular")
public class GrupoMuscularResource {

    @Autowired
    private GrupoMuscularService service;

    @GetMapping
    public ResponseEntity<List<GrupoMuscular>> findAll() {
        List<GrupoMuscular> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GrupoMuscular> findById(@PathVariable String id) {
        GrupoMuscular obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<GrupoMuscular> insert(@Valid @RequestBody GrupoMuscular obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GrupoMuscular> update(@PathVariable String id, @RequestBody GrupoMuscular obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
