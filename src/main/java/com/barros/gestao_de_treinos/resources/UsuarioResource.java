package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.DTOs.UsuarioDTO;
import com.barros.gestao_de_treinos.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable String id) {
        UsuarioDTO obj = service.findDtoById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> insert(@Valid @RequestBody UsuarioDTO obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuario()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable String id, @Valid @RequestBody UsuarioDTO obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        UsuarioDTO usuario = service.autenticar(loginRequest.getEmail(), loginRequest.getSenha());

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
        }
    }

    @GetMapping("/alunos")
    public ResponseEntity<List<UsuarioDTO>> findAllAlunos() {
        List<UsuarioDTO> alunos = service.findAllAlunos();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/instrutores")
    public ResponseEntity<List<UsuarioDTO>> findAllInstrutores() {
        List<UsuarioDTO> alunos = service.findAllInstrutores();
        return ResponseEntity.ok().body(alunos);
    }

}
