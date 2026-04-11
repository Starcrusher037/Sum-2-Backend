package com.duoc.LearningPlatform.repository;

import com.duoc.LearningPlatform.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//interfaz que extiende de jpaRepository, maneja la entidad Curso con PK de tipo long
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    //funcion que representa una consulta la cual trae los cursos activos ordenados por nombre ascendente
    List<Curso> findByActivoTrueOrderByNombreAsc();
}