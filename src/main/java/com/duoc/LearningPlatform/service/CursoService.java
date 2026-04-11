package com.duoc.LearningPlatform.service;

import com.duoc.LearningPlatform.model.Curso;
import com.duoc.LearningPlatform.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    //utiliza la funcion de la interface para la obtencion de cursos activos
    public List<Curso> obtenerCursosActivos() {
        return cursoRepository.findByActivoTrueOrderByNombreAsc();
    }

    //obtiene cursos activos y los formatea, devuelve lista de string con los datos del curso
    public List<String> obtenerCursosFormateados() {
        List<Curso> cursos = obtenerCursosActivos();
        List<String> resultado = new ArrayList<>();

        //por cada curso en la lista "cursos" obtiene el nombre, docente y cantidad de horas,
        //  esto lo inserta en la lista resultado. 
        for (Curso curso : cursos) {
            String texto = "Curso: " + curso.getNombre()
                    + " | Docente: " + curso.getDocente()
                    + " | Duración: " + curso.getDuracionHoras() + " horas";
            resultado.add(texto);
        }
        return resultado;
    }
    
}