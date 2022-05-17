package com.kreitek.school.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class LeccionDto implements Serializable {

    private long id;
    private String contenido;
    private String titulo;
    private Integer orden;
    private Long cursoId;
    private String cursoNombre;
    private Long profesorId;
    private String profesorNombre;

    public LeccionDto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public String getProfesorNombre() {
        return profesorNombre;
    }

    public void setProfesorNombre(String profesorNombre) {
        this.profesorNombre = profesorNombre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,contenido,titulo,orden);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        LeccionDto o = (LeccionDto) obj;
        return Objects.equals(this.id, o.id) &&
                Objects.equals(this.contenido, o.contenido) &&
                Objects.equals(this.orden, o.orden) &&
                Objects.equals(this.titulo, o.titulo);
    }

    @Override
    public String toString() {
        return "LeccionDto{" +
                "id=" + id +
                ", contenido='" + contenido + '\'' +
                ", titulo='" + titulo +
                ", orden=" + orden + '\'' +
                '}';
    }
}
