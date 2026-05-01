package com.duoc.LearningPlatform.model;

import java.sql.Date;

import org.hibernate.annotations.NotFound;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inscripcion")

public class Inscripcion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotFound
    @Min(value = 1)
    private long cursoId;
    
    @NotFound
    @Min(value = 1)
    private long estudianteId;

    @NotNull
    @PastOrPresent
    Date fechaInscripcion;
}
