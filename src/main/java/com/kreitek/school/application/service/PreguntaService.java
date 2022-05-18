package com.kreitek.school.application.service;

import com.kreitek.school.application.dto.PreguntaDto;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {

    List<PreguntaDto> obtenerPreguntas();
    Optional<PreguntaDto> obtenerPreguntaPorId(Long preguntaId);
    PreguntaDto crearPregunta(PreguntaDto preguntaDto);

}
