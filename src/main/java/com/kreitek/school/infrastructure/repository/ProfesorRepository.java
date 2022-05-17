package com.kreitek.school.infrastructure.repository;

import com.kreitek.school.domain.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
