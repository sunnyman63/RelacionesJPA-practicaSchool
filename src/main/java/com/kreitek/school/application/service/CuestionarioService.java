package com.kreitek.school.application.service;

import com.kreitek.school.application.dto.CuestionarioDto;
import com.kreitek.school.application.dto.PreguntaCuestionarioDto;

import java.util.List;
import java.util.Optional;

public interface CuestionarioService {

    List<CuestionarioDto> obtenerCuestionarios();
    Optional<CuestionarioDto> obtenerCuestionarioPorId(Long cuestionarioId);
    CuestionarioDto crearCuestionario(CuestionarioDto cuestionarioDto);

    List<PreguntaCuestionarioDto> anyadePreguntasEnCuestionario(Long cuestionarioId, PreguntaCuestionarioDto preguntaCuestionarioDto);

    List<PreguntaCuestionarioDto> obtenerPreguntasDeCuestionario(Long cuestionarioId);
}
