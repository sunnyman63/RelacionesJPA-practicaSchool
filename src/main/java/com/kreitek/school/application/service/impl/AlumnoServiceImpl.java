package com.kreitek.school.application.service.impl;

import com.kreitek.school.application.dto.AlumnoDto;
import com.kreitek.school.application.dto.CalificacionDto;
import com.kreitek.school.application.dto.CursoSimpleDto;
import com.kreitek.school.application.mapper.AlumnoMapper;
import com.kreitek.school.application.service.AlumnoService;
import com.kreitek.school.domain.entity.Alumno;
import com.kreitek.school.infrastructure.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;

    @Autowired
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper) {
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
    }

    @Override
    public List<AlumnoDto> obtenerAlumnos() {
        var alumnos = alumnoRepository.findAll();
        return alumnoMapper.toDto(alumnos);
    }

    @Override
    public Optional<AlumnoDto> obtenerAlumnoPorId(Long alumnoId) {
        return alumnoRepository
                .findById(alumnoId)
                .map(alumnoMapper::toDto);
    }

    @Override
    public AlumnoDto crearAlumno(AlumnoDto alumnoDto) {
        var alumno = alumnoMapper.toEntity(alumnoDto);
        alumno = alumnoRepository.save(alumno);
        return alumnoMapper.toDto(alumno);
    }

    @Override
    public void eliminarAlumnoPorId(Long alumnoId) {
        alumnoRepository.deleteById(alumnoId);
    }

    @Override
    @Transactional
    public List<CursoSimpleDto> registrarAlumnoEnCurso(Long alumnoId, CursoSimpleDto cursoSimpleDto) {
        AlumnoDto alumnoDto = obtenerAlumnoPorId(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no existe"));

        alumnoDto.getCursos().add(cursoSimpleDto);
        Alumno alumno = alumnoRepository.save(alumnoMapper.toEntity(alumnoDto));
        alumnoDto = alumnoMapper.toDto(alumno);
        return alumnoDto.getCursos();
    }

    @Override
    @Transactional
    public void eliminarCursoDeAlumno(Long alumnoId, Long cursoId) {
        Alumno alumno = alumnoRepository
                .findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        alumno.eliminarCursoPorId(cursoId);
        alumnoRepository.save(alumno);
    }

    @Override
    public AlumnoDto anyadirCalificacion(Long alumnoId, CalificacionDto calificacionDto) {
        AlumnoDto alumnoDto = obtenerAlumnoPorId(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        alumnoDto.getCalificaciones().add(calificacionDto);
        Alumno alumno = alumnoRepository.save(alumnoMapper.toEntity(alumnoDto));
        return alumnoMapper.toDto(alumno);
    }
}
