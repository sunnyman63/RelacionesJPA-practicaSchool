package com.kreitek.school.infrastructure.repository;

import com.kreitek.school.application.dto.PreguntaCuestionarioDto;
import com.kreitek.school.domain.entity.PreguntaCuestionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaCuestionarioRepository extends JpaRepository<PreguntaCuestionario, Long> {
}
