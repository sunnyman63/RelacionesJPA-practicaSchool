package com.kreitek.school.domain.entity;

import com.kreitek.school.application.dto.AlumnoDto;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_sequence")
    @SequenceGenerator(name = "school_sequence")
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;

    @Column(name = "RESUMEN", nullable = false, length = 2000)
    private String resumen;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    Set<Leccion> lecciones;
    @ManyToMany(mappedBy = "cursos")
    private Set<Alumno> alumnos;

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

    public Set<Leccion> getLecciones() {
        return lecciones;
    }

    public void setLecciones(Set<Leccion> lecciones) {
        this.lecciones = lecciones;
        this.lecciones.forEach(leccion -> leccion.setCurso(this));
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass() || id == null) return false;
        Curso o = (Curso) obj;
        return id.equals(o.id);
    }
}
