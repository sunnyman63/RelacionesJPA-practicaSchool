package com.kreitek.school.infrastructure.repository;

import com.kreitek.school.domain.entity.Cuestionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuestionarioRepository extends JpaRepository<Cuestionario, Long> {
}
