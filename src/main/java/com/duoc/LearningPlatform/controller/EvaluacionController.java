package com.duoc.LearningPlatform.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.duoc.LearningPlatform.model.Evaluacion;
import com.duoc.LearningPlatform.service.EvaluacionService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class EvaluacionController {

    private final EvaluacionService evaluacionService;

    public EvaluacionController(EvaluacionService evaluacionService){
        this.evaluacionService = evaluacionService;
    }


    // Mapeo consultar todas las evaluaciones
    @GetMapping("/api/evaluaciones")
    public ResponseEntity<List<Evaluacion>> obtenerTodasEvaluaciones() {
        return ResponseEntity.ok(evaluacionService.obtenerTodasEvaluaciones());
    }
    
    // Mapeo consultar evaluaciones por curso
    @GetMapping("/api/evaluaciones/{cursoId}")
    public ResponseEntity<List<Evaluacion>> ObtenerEvaluacionPorCursoId(@Valid @PathVariable @Positive Long cursoId) {
        return ResponseEntity.ok(evaluacionService.obtenerEvaluacionesPorCurso(cursoId));
    }
    

    // Mapeo registrar evaluacion
    @PostMapping("api/evaluaciones")
    public ResponseEntity<Evaluacion> registrarEvaluacion(@RequestBody @Valid Evaluacion evaluacion) {
        Evaluacion evaluacionCreada = evaluacionService.registrarEvaluacion(evaluacion);
        URI ruta = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(evaluacionCreada.getId())
            .toUri();
        return ResponseEntity.created(ruta).body(evaluacionCreada);
    }
    

    // Mapeo modificar evaluacion
    @PutMapping("api/evaluaciones/{id}")
    public ResponseEntity<Evaluacion> modificarEvaluacion(@PathVariable @Positive Long id, @RequestBody @Valid
        Evaluacion evaluacion) {
            return evaluacionService.modificarEvaluacion(id, evaluacion).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
