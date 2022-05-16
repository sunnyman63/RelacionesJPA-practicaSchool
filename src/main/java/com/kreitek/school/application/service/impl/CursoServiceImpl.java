package com.kreitek.school.application.service.impl;

import com.kreitek.school.application.dto.CursoDto;
import com.kreitek.school.application.mapper.CursoMapper;
import com.kreitek.school.application.service.CursoService;
import com.kreitek.school.domain.entity.Curso;
import com.kreitek.school.infrastructure.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository, CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CursoDto> obtenerCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        return cursoMapper.toDto(cursos);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CursoDto> obtenerCursoPorId(Long id) {
        return cursoRepository
                .findById(id)
                .map(cursoMapper::toDto);
    }

    @Override
    @Transactional
    public CursoDto crearCurso(CursoDto cursoDto) {
        Curso curso = cursoMapper.toEntity(cursoDto);
        curso = cursoRepository.save(curso);
        return cursoMapper.toDto(curso);
    }

    @Override
    @Transactional
    public void eliminarCursoPorId(Long id) {
        cursoRepository.deleteById(id);
    }
}
