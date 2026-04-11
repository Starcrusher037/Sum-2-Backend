package com.duoc.LearningPlatform.controller;

import com.duoc.LearningPlatform.model.Curso;
import com.duoc.LearningPlatform.service.CursoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Clase controlador con respuestas rest, obtiene una instancia de cursoService.
@RestController
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    //mapeo para obtener cursos activos
    @GetMapping("/cursos/activos")
    public List<Curso> obtenerCursosActivos() {
        return cursoService.obtenerCursosActivos();
    }

    //mapeo para obtencion de cursos activos formateados
    @GetMapping("/cursos/activos/formateados")
    public List<String> obtenerCursosFormateados() {
        return cursoService.obtenerCursosFormateados();
    }
}