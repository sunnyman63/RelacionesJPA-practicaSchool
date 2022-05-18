package com.kreitek.school.application.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CuestionarioDto implements Serializable {

    private Long id;
    private Integer notaMinima;
    private String titulo;

    private List<PreguntaCuestionarioDto> preguntas;

    public CuestionarioDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(Integer notaMinima) {
        this.notaMinima = notaMinima;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<PreguntaCuestionarioDto> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaCuestionarioDto> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuestionarioDto that = (CuestionarioDto) o;
        return id.equals(that.id) &&
                notaMinima.equals(that.notaMinima) &&
                titulo.equals(that.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, notaMinima, titulo);
    }

    @Override
    public String toString() {
        return "CuestionarioDto{" +
                "id=" + id +
                ", notaMinima=" + notaMinima +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
