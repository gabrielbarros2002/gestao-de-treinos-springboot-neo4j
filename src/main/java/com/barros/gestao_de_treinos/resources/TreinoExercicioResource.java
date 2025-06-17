package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.entities.PK.TreinoExercicioPK;
import com.barros.gestao_de_treinos.entities.Treino;
import com.barros.gestao_de_treinos.entities.TreinoExercicio;
import com.barros.gestao_de_treinos.services.ExercicioService;
import com.barros.gestao_de_treinos.services.TreinoExercicioService;
import com.barros.gestao_de_treinos.services.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/treino-exercicio")
public class TreinoExercicioResource {

    @Autowired
    private TreinoExercicioService service;

    @Autowired
    private TreinoService treinoService;

    @Autowired
    private ExercicioService exercicioService;

    @GetMapping
    public ResponseEntity<List<TreinoExercicio>> findAll() {
        List<TreinoExercicio> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<TreinoExercicio> findById(
            @RequestParam Long treinoId,
            @RequestParam Long exercicioId
    ) {
        Treino treino = treinoService.findById(treinoId);
        Exercicio exercicio = exercicioService.findById(exercicioId);
        TreinoExercicioPK pk = new TreinoExercicioPK(treino, exercicio);
        TreinoExercicio obj = service.findById(pk);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/treino/{treinoId}")
    public ResponseEntity<List<TreinoExercicio>> findByTreinoId(@PathVariable Long treinoId) {
        List<TreinoExercicio> treinoExercicios = service.buscarTreinoExercicioPorTreino(treinoId);
        if (treinoExercicios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(treinoExercicios);
    }

}
