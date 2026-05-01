package com.duoc.LearningPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.LearningPlatform.model.Inscripcion;
import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long>{

    List<Inscripcion> findByCursoId(long cursoId);

    Boolean existsByCursoId(long cursoId);
}
