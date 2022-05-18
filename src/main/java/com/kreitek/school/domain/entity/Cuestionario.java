package com.kreitek.school.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cuestionarios")
public class Cuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_sequence")
    @SequenceGenerator(name = "school_sequence")
    private Long id;

    @Column(name = "NOTA_MINIMA", nullable = false)
    private Integer notaMinima;

    @Column(name = "TITULO", nullable = false, length = 255)
    private String titulo;

    @OneToMany(mappedBy = "cuestionario", cascade = CascadeType.ALL)
    private Set<PreguntaCuestionario> preguntas;

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

    public Set<PreguntaCuestionario> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<PreguntaCuestionario> preguntas) {
        this.preguntas = preguntas;
    }
}
