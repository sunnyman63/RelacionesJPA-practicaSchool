package com.kreitek.school.application.dto;

import java.util.Objects;

public class ProfesorDto {

    private Long id;
    private String nombre;
    private String numeroTelefono;

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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nombre,numeroTelefono);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        ProfesorDto o = (ProfesorDto) obj;
        return Objects.equals(this.id, o.id) &&
                Objects.equals(this.nombre, o.nombre) &&
                Objects.equals(this.numeroTelefono, o.numeroTelefono);
    }

    @Override
    public String toString() {
        return "ProfesorDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                '}';
    }
}
