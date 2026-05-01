package com.duoc.LearningPlatform.controller;

import com.duoc.LearningPlatform.model.Curso;
import com.duoc.LearningPlatform.service.CursoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



//Clase controlador con respuestas rest, obtiene una instancia de cursoService.
@RestController
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    //mapeo para obtener todos los cursos
    @GetMapping("/api/cursos")
    public ResponseEntity<List<Curso>> obtenerTodosCursos() {
        return ResponseEntity.ok(cursoService.obtenerTodosCursos());
    }

    //mapeo para obtencion de curso por id 
    @GetMapping("/api/cursos/{id}")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable @Positive long id) {
        return cursoService.obtenerCursoPorId(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    //mapeo para registrar curso
    @PostMapping("/api/cursos")
    public ResponseEntity<Curso> registrarCurso(@Valid @RequestBody Curso curso) {
        Curso cursoCreado = cursoService.registrarCurso(curso);
        URI ruta = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(cursoCreado.getId())
            .toUri();
        return ResponseEntity.created(ruta).body(cursoCreado);
    }

    // mapeo para modificacion de curso
    @PutMapping("/api/cursos/{id}")
    public ResponseEntity<Curso> actualizarCurso(@Valid @PathVariable @Positive Long id, @Valid @RequestBody Curso curso) {
        return cursoService.modificarCurso(id, curso).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    // mapeo para eliminar curso 
    @DeleteMapping("/api/cursos/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable @Positive Long id){
        return cursoService.eliminarCurso(id)
        ? ResponseEntity.noContent().build()
        : ResponseEntity.notFound().build();
    }
    

}