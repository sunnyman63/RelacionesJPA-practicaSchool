package com.kreitek.school.application.service;

import com.kreitek.school.application.dto.CalificacionDto;

import java.util.List;
import java.util.Optional;

public interface CalificacionService {

    List<CalificacionDto> obtenerCalificacionesDeUnAlumno(Long alumnoId);
    Optional<CalificacionDto> obtenerCalificacionDeUnAlumno(Long alumnoId, Long calificacionId);
    List<CalificacionDto> crearCalificacionDeAlumno(Long alumnoId, CalificacionDto calificacionDto);

}
