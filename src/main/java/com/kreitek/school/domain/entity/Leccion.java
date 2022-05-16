package com.kreitek.school.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "lecciones")
public class Leccion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_sequence")
    @SequenceGenerator(name = "school_sequence")
    private long id;

    @Column(name = "CONTENIDO", nullable = false, length = 2000)
    private String contenido;

    @Column(name = "TITULO", nullable = false, length = 100)
    private String titulo;

    @Column(name = "ORDEN", nullable = false)
    private Integer orden;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}