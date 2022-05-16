package com.kreitek.school.application.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CursoDto implements Serializable {

    private long id;
    private String nombre;
    private String resumen;

    List<LeccionDto> lecciones;

    public CursoDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public List<LeccionDto> getLecciones() {
        return lecciones;
    }

    public void setLecciones(List<LeccionDto> lecciones) {
        this.lecciones = lecciones;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nombre,resumen);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        CursoDto o = (CursoDto) obj;
        return Objects.equals(this.id, o.id) &&
                Objects.equals(this.nombre, o.nombre) &&
                Objects.equals(this.resumen, o.resumen);
    }

    @Override
    public String toString() {
        return "CursoDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", resumen='" + resumen + '\'' +
                '}';
    }
}
