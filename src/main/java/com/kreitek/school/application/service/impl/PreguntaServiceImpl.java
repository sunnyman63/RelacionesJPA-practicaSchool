package com.kreitek.school.application.service.impl;

import com.kreitek.school.application.dto.PreguntaDto;
import com.kreitek.school.application.mapper.PreguntaMapper;
import com.kreitek.school.application.service.PreguntaService;
import com.kreitek.school.domain.entity.Cuestionario;
import com.kreitek.school.domain.entity.Pregunta;
import com.kreitek.school.infrastructure.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository preguntaRepository;
    private final PreguntaMapper preguntaMapper;

    @Autowired
    public PreguntaServiceImpl(PreguntaRepository preguntaRepository, PreguntaMapper preguntaMapper) {
        this.preguntaRepository = preguntaRepository;
        this.preguntaMapper = preguntaMapper;
    }

    @Override
    public List<PreguntaDto> obtenerPreguntas() {
        List<Pregunta> preguntas = preguntaRepository.findAll();
        return preguntaMapper.toDto(preguntas);
    }

    @Override
    public Optional<PreguntaDto> obtenerPreguntaPorId(Long preguntaId) {
        return preguntaRepository
                .findById(preguntaId)
                .map(preguntaMapper::toDto);
    }

    @Override
    public PreguntaDto crearPregunta(PreguntaDto preguntaDto) {
        Pregunta pregunta = preguntaMapper.toEntity(preguntaDto);
        pregunta = preguntaRepository.save(pregunta);
        return preguntaMapper.toDto(pregunta);
    }
}
