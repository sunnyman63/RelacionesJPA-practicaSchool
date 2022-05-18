package com.kreitek.school.infrastructure.rest;

import com.kreitek.school.application.dto.CuestionarioDto;
import com.kreitek.school.application.dto.PreguntaDto;
import com.kreitek.school.application.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PreguntaRestController {

    private final PreguntaService preguntaService;

    @Autowired
    public PreguntaRestController(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    @GetMapping(value = "/preguntas", produces = "application/json")
    public ResponseEntity<List<PreguntaDto>> obtenerPreguntas() {
        List<PreguntaDto> preguntaDtos = preguntaService.obtenerPreguntas();
        return new ResponseEntity<>(preguntaDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/preguntas/{preguntaId}", produces = "application/json")
    public ResponseEntity<PreguntaDto> obtenerPregunta(@PathVariable Long preguntaId) {
        return preguntaService
                .obtenerPreguntaPorId(preguntaId)
                .map(preguntaDto -> new ResponseEntity<>(preguntaDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping(value = "/preguntas", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PreguntaDto> crearCuestionario(@RequestBody PreguntaDto preguntaDto) {
        preguntaDto = preguntaService.crearPregunta(preguntaDto);
        return new ResponseEntity<>(preguntaDto,HttpStatus.CREATED);
    }
}
