package com.kreitek.school.application.service;

import com.kreitek.school.application.dto.AlumnoDto;
import com.kreitek.school.application.dto.CalificacionDto;
import com.kreitek.school.application.dto.CursoSimpleDto;
import com.kreitek.school.application.dto.ProfesorDto;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    List<AlumnoDto> obtenerAlumnos();
    Optional<AlumnoDto> obtenerAlumnoPorId(Long alumnoId);
    AlumnoDto crearAlumno(AlumnoDto alumnoDto);

    void eliminarAlumnoPorId(Long alumnoId);

    List<CursoSimpleDto> registrarAlumnoEnCurso(Long alumnoId, CursoSimpleDto cursoSimpleDto);

    void eliminarCursoDeAlumno(Long alumnoId, Long cursoId);

    AlumnoDto anyadirCalificacion(Long alumnoId, CalificacionDto calificacionDto);
}
