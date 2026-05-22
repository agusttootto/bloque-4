package com.ejercicio.bloque4.Controller;

import com.ejercicio.bloque4.model.VisitanteJpa;
import com.ejercicio.bloque4.service.VisitanteService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dinosaurios")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class VisitanteController {
    
    private final VisitanteService visitanteService;
    
    @GetMapping
    public List<VisitanteJpa> listar() {
        return visitanteService.listarTodos();
    }
    
    @PostMapping
    public VisitanteJpa crear(@RequestBody VisitanteJpa visitante) {
        return visitanteService.guardar(visitante);
    }
}