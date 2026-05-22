package com.ejercicio.bloque4.Controller;

import com.ejercicio.bloque4.model.DinosaurioJpa;
import com.ejercicio.bloque4.service.DinosaurioService;
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
public class DinosaurioController {
    
    private final DinosaurioService dinosaurioService;
    
    @GetMapping
    public List<DinosaurioJpa> listar() {
        return dinosaurioService.listarTodos();
    }
    
    @PostMapping
    public DinosaurioJpa crear(@RequestBody DinosaurioJpa dinosaurio) {
        return dinosaurioService.guardar(dinosaurio);
    }
    
    @PostMapping("/alimentar")
    public void alimentarTodos() {
        dinosaurioService.alimentarTodos();
    }
}