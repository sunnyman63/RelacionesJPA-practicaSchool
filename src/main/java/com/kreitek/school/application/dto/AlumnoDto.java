package com.kreitek.school.application.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AlumnoDto implements Serializable {

    private Long id;
    private String nombre;
    private String url;
    private List<CursoSimpleDto> cursos;

    private List<CalificacionDto> calificaciones;

    public AlumnoDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<CursoSimpleDto> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoSimpleDto> cursos) {
        this.cursos = cursos;
    }

    public List<CalificacionDto> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionDto> calificaciones) {
        this.calificaciones = calificaciones;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nombre,url);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        AlumnoDto o = (AlumnoDto) obj;
        return Objects.equals(this.id, o.id) &&
                Objects.equals(this.nombre, o.nombre) &&
                Objects.equals(this.url, o.url);
    }

    @Override
    public String toString() {
        return "AlumnoDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
