package com.duoc.LearningPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duoc.LearningPlatform.model.Evaluacion;
import com.duoc.LearningPlatform.repository.CursoRepository;
import com.duoc.LearningPlatform.repository.EvaluacionRepository;

@Service
public class EvaluacionService {

    private final EvaluacionRepository evaluacionRepository;
    private final CursoRepository cursoRepository;

    public EvaluacionService(EvaluacionRepository evaluacionRepository, CursoRepository cursoRepository){
        this.evaluacionRepository = evaluacionRepository;
        this.cursoRepository = cursoRepository;
    }

    // Obtener todas las evaluaciones
    public List<Evaluacion> obtenerTodasEvaluaciones(){
        return evaluacionRepository.findAll();
    }

    // Obtener las evaluaciones por cursoId
    public List<Evaluacion> obtenerEvaluacionesPorCurso(long cursoId){
        if(! cursoRepository.existsById(cursoId)){
            throw new RuntimeException("El curso no existe");
        } 
        return evaluacionRepository.findByCursoId(cursoId);
    }

    //registrar evaluacion
    public Evaluacion registrarEvaluacion(Evaluacion evaluacion){
        return evaluacionRepository.save(evaluacion);
    }

    //Modificar evaluacion
    public Optional<Evaluacion> modificarEvaluacion(Long id, Evaluacion evaluacion){
        if (evaluacionRepository.existsById(id)) {
            evaluacion.setId(id);
            return Optional.of(evaluacionRepository.save(evaluacion));
        }
        return Optional.empty();
    }

    
}
