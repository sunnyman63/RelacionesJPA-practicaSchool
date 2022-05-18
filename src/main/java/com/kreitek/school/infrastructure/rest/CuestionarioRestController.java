package com.kreitek.school.infrastructure.rest;

import com.kreitek.school.application.dto.AdjuntoDto;
import com.kreitek.school.application.dto.CuestionarioDto;
import com.kreitek.school.application.dto.PreguntaCuestionarioDto;
import com.kreitek.school.application.service.CuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuestionarioRestController {

    private final CuestionarioService cuestionarioService;

    @Autowired
    public CuestionarioRestController(CuestionarioService cuestionarioService) {
        this.cuestionarioService = cuestionarioService;
    }

    @GetMapping(value = "/cuestionarios", produces = "application/json")
    public ResponseEntity<List<CuestionarioDto>> obtenerCuestionarios() {
        List<CuestionarioDto> cuestionarioDtos = cuestionarioService.obtenerCuestionarios();
        return new ResponseEntity<>(cuestionarioDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/cuestionarios{cuestionarioId}", produces = "application/json")
    public ResponseEntity<CuestionarioDto> obtenerCuestionario(@PathVariable Long cuestionarioId) {
        return cuestionarioService
                .obtenerCuestionarioPorId(cuestionarioId)
                .map(cuestionarioDto -> new ResponseEntity<>(cuestionarioDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping(value = "/cuestionarios", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CuestionarioDto> crearCuestionario(@RequestBody CuestionarioDto cuestionarioDto) {
        cuestionarioDto = cuestionarioService.crearCuestionario(cuestionarioDto);
        return new ResponseEntity<>(cuestionarioDto,HttpStatus.CREATED);
    }

    @PutMapping(value = "/cuestionarios/{cuestionarioId}/preguntas", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<PreguntaCuestionarioDto>> anyadePreguntaEnCuestionario(
            @PathVariable Long cuestionarioId,
            @RequestBody PreguntaCuestionarioDto preguntaCuestionarioDto) {
        List<PreguntaCuestionarioDto> preguntaCuestionarioDtos = cuestionarioService
                .anyadePreguntasEnCuestionario(cuestionarioId, preguntaCuestionarioDto);
        return new ResponseEntity<>(preguntaCuestionarioDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/cuestionarios/{cuestionarioId}/preguntas", produces = "application/json")
    public ResponseEntity<List<PreguntaCuestionarioDto>> obtenerPreguntasDeCuestionario(@PathVariable Long cuestionarioId) {
        List<PreguntaCuestionarioDto> preguntaCuestionarioDtos = cuestionarioService
                .obtenerPreguntasDeCuestionario(cuestionarioId);
        return new ResponseEntity<>(preguntaCuestionarioDtos, HttpStatus.OK);
    }
}
