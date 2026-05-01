package com.duoc.LearningPlatform.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "evaluacion")
@NoArgsConstructor
@AllArgsConstructor

public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //clave foranea
    @NotNull
    Long cursoId;

    @NotBlank
    String nombre;

    @Min(value = 1)
    int puntajeMaximo;

    @NotNull
    @PastOrPresent
    Date fechaAplicacion;

}
