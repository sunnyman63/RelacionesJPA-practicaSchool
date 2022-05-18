package com.kreitek.school.application.service;

import com.kreitek.school.application.dto.AdjuntoDto;
import com.kreitek.school.application.dto.LeccionDto;

import java.util.List;
import java.util.Optional;

public interface LeccionService {

    List<LeccionDto> obtenerLeccionesDeUnCurso(Long cursoId);
    LeccionDto crearLeccion( Long cursoId, LeccionDto leccionDto);
    Optional<LeccionDto> obtenerLeccionDeUnCurso(Long id, Long leccionId);

    List<AdjuntoDto> adjuntoFichero(Long cursoId, Long leccionId, AdjuntoDto adjuntoDto);
}
