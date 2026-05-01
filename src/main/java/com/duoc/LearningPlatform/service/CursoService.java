package com.duoc.LearningPlatform.service;

import com.duoc.LearningPlatform.model.Curso;
import com.duoc.LearningPlatform.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    //Obtencion de todos los cursos
    public List<Curso> obtenerTodosCursos() {
        return cursoRepository.findAll();
    }

    //obtiene cursos por id 
    public Optional<Curso> obtenerCursoPorId(Long id) {
      return cursoRepository.findById(id);
    }
    
    // Agregar curso
    public Curso registrarCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    //Modificar curso por id
    public Optional<Curso> modificarCurso(long id, Curso curso){
        if(cursoRepository.existsById(id)){
            curso.setId(id);
            return Optional.of(cursoRepository.save(curso));
        }
        return Optional.empty();
    }

    // Borrar curso por id
    public Boolean eliminarCurso(long id){
        if(!cursoRepository.existsById(id)){
            return false;
        }
        cursoRepository.deleteById(id);
        return true;
    }
}