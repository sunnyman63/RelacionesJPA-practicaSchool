package com.kreitek.school.application.service.impl;

import com.kreitek.school.application.dto.AlumnoDto;
import com.kreitek.school.application.dto.CuestionarioDto;
import com.kreitek.school.application.dto.CursoDto;
import com.kreitek.school.application.dto.PreguntaCuestionarioDto;
import com.kreitek.school.application.mapper.CuestionarioMapper;
import com.kreitek.school.application.mapper.CursoMapper;
import com.kreitek.school.application.service.CuestionarioService;
import com.kreitek.school.domain.entity.Cuestionario;
import com.kreitek.school.domain.entity.Curso;
import com.kreitek.school.infrastructure.repository.CuestionarioRepository;
import com.kreitek.school.infrastructure.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CuestionarioServiceImpl implements CuestionarioService {

    private final CuestionarioRepository cuestionarioRepository;
    private final CuestionarioMapper cuestionarioMapper;

    @Autowired
    public CuestionarioServiceImpl(CuestionarioRepository cuestionarioRepository, CuestionarioMapper cuestionarioMapper) {
        this.cuestionarioRepository = cuestionarioRepository;
        this.cuestionarioMapper = cuestionarioMapper;
    }

    @Override
    public List<CuestionarioDto> obtenerCuestionarios() {
        List<Cuestionario> cuestionarios = cuestionarioRepository.findAll();
        return cuestionarioMapper.toDto(cuestionarios);
    }

    @Override
    public Optional<CuestionarioDto> obtenerCuestionarioPorId(Long id) {
        return cuestionarioRepository
                .findById(id)
                .map(cuestionarioMapper::toDto);
    }

    @Override
    public CuestionarioDto crearCuestionario(CuestionarioDto cuestionarioDto) {
        Cuestionario cuestionario = cuestionarioMapper.toEntity(cuestionarioDto);
        cuestionario = cuestionarioRepository.save(cuestionario);
        return cuestionarioMapper.toDto(cuestionario);
    }

    @Override
    @Transactional
    public List<PreguntaCuestionarioDto> anyadePreguntasEnCuestionario(Long cuestionarioId,
                                                                       PreguntaCuestionarioDto preguntaCuestionarioDto) {
        CuestionarioDto cuestionarioDto = obtenerCuestionarioPorId(cuestionarioId)
                .orElseThrow(() -> new RuntimeException("Cuestionario no encontrado"));
        preguntaCuestionarioDto.setCuestionarioId(cuestionarioId);
        cuestionarioDto.getPreguntas().add(preguntaCuestionarioDto);
        Cuestionario cuestionario = cuestionarioRepository.save(cuestionarioMapper.toEntity(cuestionarioDto));
        cuestionarioDto =cuestionarioMapper.toDto(cuestionario);
        return cuestionarioDto.getPreguntas();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PreguntaCuestionarioDto> obtenerPreguntasDeCuestionario(Long cuestionarioId) {
        CuestionarioDto cuestionarioDto = obtenerCuestionarioPorId(cuestionarioId)
                .orElseThrow(() -> new RuntimeException("Cuestionario no encontrado"));

        return cuestionarioDto.getPreguntas();
    }
}
