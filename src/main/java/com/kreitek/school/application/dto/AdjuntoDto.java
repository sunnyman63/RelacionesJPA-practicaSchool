package com.kreitek.school.application.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class AdjuntoDto implements Serializable {

    private Long id;
    private String nombre;
    private String mineType;
    private byte[] contenido;

    public AdjuntoDto() {
    }

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

    public String getMineType() {
        return mineType;
    }

    public void setMineType(String mineType) {
        this.mineType = mineType;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdjuntoDto that = (AdjuntoDto) o;
        return id.equals(that.id) && nombre.equals(that.nombre) && mineType.equals(that.mineType) && Arrays.equals(contenido, that.contenido);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, nombre, mineType);
        result = 31 * result + Arrays.hashCode(contenido);
        return result;
    }

    @Override
    public String toString() {
        return "AdjuntoDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", mineType='" + mineType + '\'' +
                ", contenido=" + Arrays.toString(contenido) +
                '}';
    }
}
