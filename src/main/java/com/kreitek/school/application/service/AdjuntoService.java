package com.kreitek.school.application.service;

import com.kreitek.school.application.dto.AdjuntoDto;

import java.util.List;
import java.util.Optional;

public interface AdjuntoService {
    List<AdjuntoDto> obtenerAdjuntos();
    Optional<AdjuntoDto> obtenerAdjunto(Long adjuntoId);
    AdjuntoDto crearAdjunto(AdjuntoDto adjuntoDtos);
}
