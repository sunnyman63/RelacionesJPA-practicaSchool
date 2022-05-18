package com.kreitek.school.application.mapper;

import com.kreitek.school.application.dto.AlumnoDto;
import com.kreitek.school.application.dto.AlumnoSimpleDto;
import com.kreitek.school.domain.entity.Alumno;
import com.kreitek.school.domain.entity.Cuestionario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { CursoMapper.class })
public interface AlumnoMapper extends EntityMapper<AlumnoDto, Alumno> {

    @Mapping(target = "url", ignore = true)
    @Mapping(target = "cursos", ignore = true)

    Alumno toEntity(AlumnoSimpleDto alumnoSimpleDto);
    AlumnoSimpleDto toSimpleDto(Alumno alumno);

    default Alumno fromId(Long id) {
        if(id==null) return null;
        Alumno alumno = new Alumno();
        alumno.setId(id);
        return alumno;
    }
}
