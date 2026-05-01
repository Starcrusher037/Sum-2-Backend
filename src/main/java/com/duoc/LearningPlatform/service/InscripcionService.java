package com.duoc.LearningPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.duoc.LearningPlatform.model.Inscripcion;
import com.duoc.LearningPlatform.repository.CursoRepository;
import com.duoc.LearningPlatform.repository.InscripcionRepository;

@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final CursoRepository cursoRepository;

    public InscripcionService(InscripcionRepository inscripcionRepository, CursoRepository cursoRepository){
        this.inscripcionRepository = inscripcionRepository;
        this.cursoRepository = cursoRepository;
    }

    //Consultar inscripciones por curso
    public List<Inscripcion> obtenerInscripcionesCursoId(long cursoId){
        if(!cursoRepository.existsById(cursoId)){
            throw new RuntimeException("El curso no existe");
        }
        return inscripcionRepository.findByCursoId(cursoId);
    }

    //Registrar inscripcion
    public Inscripcion registrarInscripcion(Inscripcion inscripcion){
        return inscripcionRepository.save(inscripcion);
    }

    //Eliminar Inscripcion
    public Boolean eliminarInscripcion(long id){
        if (inscripcionRepository.existsById(id)) {
            inscripcionRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
