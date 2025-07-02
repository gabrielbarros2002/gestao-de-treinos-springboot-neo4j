package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.DTOs.TreinoDTO;
import com.barros.gestao_de_treinos.services.TreinoService;
import com.barros.gestao_de_treinos.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/treino")
public class TreinoResource {

    @Autowired
    private TreinoService service;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<TreinoDTO>> findAll() {
        List<TreinoDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TreinoDTO> findById(@PathVariable String id) {
        TreinoDTO obj = service.findDtoById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<TreinoDTO> insert(@Valid @RequestBody TreinoDTO obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTreino()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TreinoDTO> update(@PathVariable String id, @Valid @RequestBody TreinoDTO obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/aluno/{alunoId}")
    public ResponseEntity<List<TreinoDTO>> buscarTreinosPorAluno(@PathVariable String alunoId) {
        List<TreinoDTO> treinos =  service.buscarTreinosPorAluno(alunoId);
        if (treinos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(treinos);
    }
}
