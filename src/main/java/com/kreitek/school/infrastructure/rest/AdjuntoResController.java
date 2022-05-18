package com.kreitek.school.infrastructure.rest;

import com.kreitek.school.application.dto.AdjuntoDto;
import com.kreitek.school.application.dto.LeccionDto;
import com.kreitek.school.application.service.AdjuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdjuntoResController {

    private final AdjuntoService adjuntoService;

    @Autowired
    public AdjuntoResController(AdjuntoService adjuntoService) {
        this.adjuntoService = adjuntoService;
    }

    @GetMapping(value = "/adjuntos", produces = "application/json")
    public ResponseEntity<List<AdjuntoDto>> obtenerAdjuntos() {
        List<AdjuntoDto> adjuntoDtos = adjuntoService.obtenerAdjuntos();
        return new ResponseEntity<>(adjuntoDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/adjuntos{adjuntoId}", produces = "application/json")
    public ResponseEntity<AdjuntoDto> obtenerAdjunto(@PathVariable Long adjuntoId) {
        return adjuntoService
                .obtenerAdjunto(adjuntoId)
                .map(adjuntoDto -> new ResponseEntity<>(adjuntoDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping(value = "/adjunto", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AdjuntoDto> crearLeccionEnCurso(@RequestBody AdjuntoDto adjuntoDtos) {
        adjuntoDtos = adjuntoService.crearAdjunto(adjuntoDtos);
        return new ResponseEntity<>(adjuntoDtos,HttpStatus.CREATED);
    }

}
