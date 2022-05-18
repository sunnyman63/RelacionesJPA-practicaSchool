package com.kreitek.school.application.mapper;

import com.kreitek.school.application.dto.CalificacionDto;
import com.kreitek.school.domain.entity.Calificacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { CuestionarioMapper.class, AlumnoMapper.class })
public interface CalificacionMapper extends EntityMapper<CalificacionDto, Calificacion> {

    @Override
    @Mapping(source = "cuestionarioId", target = "cuestionario")
    @Mapping(source = "alumnoId", target = "alumno")
    Calificacion toEntity(CalificacionDto dto);

    @Override
    @Mapping(source = "cuestionario.id", target = "cuestionarioId")
    @Mapping(source = "cuestionario.titulo", target = "cuestionarioTitulo")
    @Mapping(source = "alumno.id", target = "alumnoId")
    CalificacionDto toDto(Calificacion entity);

}
