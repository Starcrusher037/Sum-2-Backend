package com.duoc.LearningPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    private Long id;

    private String nombre;
    private String docente;
    private Boolean activo;

    @Column(name = "duracion_horas")
    private Integer duracionHoras;

    public Curso() {
    }

    public Curso(Long id, String nombre, String docente, Boolean activo, Integer duracionHoras) {
        this.id = id;
        this.nombre = nombre;
        this.docente = docente;
        this.activo = activo;
        this.duracionHoras = duracionHoras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(Integer duracionHoras) {
        this.duracionHoras = duracionHoras;
    }
}