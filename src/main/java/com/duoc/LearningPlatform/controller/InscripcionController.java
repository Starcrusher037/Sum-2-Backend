package com.duoc.LearningPlatform.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.duoc.LearningPlatform.model.Inscripcion;
import com.duoc.LearningPlatform.repository.InscripcionRepository;
import com.duoc.LearningPlatform.service.InscripcionService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class InscripcionController {

    private final InscripcionService inscripcionService;

    public InscripcionController(InscripcionService inscripcionService){
        this.inscripcionService = inscripcionService;
    }


    //Mapeo consultar inscripciones por curso
    @GetMapping("/api/inscripciones/{cursoId}")
    public ResponseEntity<List<Inscripcion>> obtenerInscripcionesPorCursoId(@PathVariable @Positive Long cursoId) {
        return ResponseEntity.ok(inscripcionService.obtenerInscripcionesCursoId(cursoId));
    }
    

    //Mapeo ingresar inscripciones
    @PostMapping("/api/inscripciones")
    public ResponseEntity<Inscripcion> registrarInscripcion(@RequestBody @Valid Inscripcion inscripcion) {
        Inscripcion inscripcionCreada = inscripcionService.registrarInscripcion(inscripcion);
         URI ruta = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(inscripcionCreada.getId())
            .toUri();
        return ResponseEntity.created(ruta).body(inscripcionCreada);
    }
    

    //Mapeo eliminar inscripcion
    @DeleteMapping("/api/inscripciones/{id}")
    public ResponseEntity<Void> eliminarInscripcion(@PathVariable @Positive Long id) {
        return inscripcionService.eliminarInscripcion(id)
        ? ResponseEntity.noContent().build()
        : ResponseEntity.notFound().build();
    }
    
}
