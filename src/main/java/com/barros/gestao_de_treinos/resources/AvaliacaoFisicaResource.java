package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.DTOs.AvaliacaoFisicaDTO;
import com.barros.gestao_de_treinos.services.AvaliacaoFisicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/avaliacao-fisica")
public class AvaliacaoFisicaResource {

    @Autowired
    private AvaliacaoFisicaService service;

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisicaDTO>> findAll() {
        List<AvaliacaoFisicaDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoFisicaDTO> findById(@PathVariable String id) {
        AvaliacaoFisicaDTO obj = service.findDtoById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoFisicaDTO> insert(@Valid @RequestBody AvaliacaoFisicaDTO obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdAvaliacao()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoFisicaDTO> update(@PathVariable String id, @Valid @RequestBody AvaliacaoFisicaDTO obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<AvaliacaoFisicaDTO>> buscarAvaliacoesPorAluno(@PathVariable String alunoId) {
        List<AvaliacaoFisicaDTO> avaliacoes = service.buscarAvaliacoesPorAluno(alunoId);
        if (avaliacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/instrutor/{instrutorId}")
    public ResponseEntity<List<AvaliacaoFisicaDTO>> buscarAvaliacoesPorInstrutor(@PathVariable String instrutorId) {
        List<AvaliacaoFisicaDTO> avaliacoes = service.buscarAvaliacoesPorInstrutor(instrutorId);
        if (avaliacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(avaliacoes);
    }
}
