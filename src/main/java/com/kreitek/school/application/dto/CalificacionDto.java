package com.kreitek.school.application.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CalificacionDto implements Serializable {

    private Long id;
    private Integer nota;
    private Date fechaCalificacion;
    private Long cuestionarioId;
    private String cuestionarioTitulo;

    private Long alumnoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Date getFechaCalificacion() {
        return fechaCalificacion;
    }

    public void setFechaCalificacion(Date fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }

    public Long getCuestionarioId() {
        return cuestionarioId;
    }

    public void setCuestionarioId(Long cuestionarioId) {
        this.cuestionarioId = cuestionarioId;
    }

    public String getCuestionarioTitulo() {
        return cuestionarioTitulo;
    }

    public void setCuestionarioTitulo(String cuestionarioTitulo) {
        this.cuestionarioTitulo = cuestionarioTitulo;
    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalificacionDto that = (CalificacionDto) o;
        return id.equals(that.id) && nota.equals(that.nota) && fechaCalificacion.equals(that.fechaCalificacion) && cuestionarioId.equals(that.cuestionarioId) && cuestionarioTitulo.equals(that.cuestionarioTitulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nota, fechaCalificacion, cuestionarioId, cuestionarioTitulo);
    }

    @Override
    public String toString() {
        return "CalificacionDto{" +
                "id=" + id +
                ", nota=" + nota +
                ", fechaCalificacion=" + fechaCalificacion +
                ", cuestionarioId=" + cuestionarioId +
                ", cuestionarioTitulo='" + cuestionarioTitulo + '\'' +
                '}';
    }
}
