package com.kreitek.school.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "preguntas")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_sequence")
    @SequenceGenerator(name = "school_sequence")
    private Long id;

    @Column(name = "PREGUNTA", nullable = false, length = 255)
    private String pregunta;

    @Column(name = "RESPUESTA", nullable = false, length = 255)
    private String respuesta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
