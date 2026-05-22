package com.ejercicio.bloque4.service;

import com.ejercicio.bloque4.model.DinosaurioJpa;
import com.ejercicio.bloque4.repository.DinosaurioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DinosaurioService {
    
    private final DinosaurioRepository repository;
    
    public List<DinosaurioJpa> listarTodos() {
        return repository.findAll();
    }
    
    public DinosaurioJpa guardar(DinosaurioJpa dino) {
        return repository.save(dino);
    }
    
    public void alimentarTodos() {
        for (DinosaurioJpa d : repository.findAll()) {
            d.alimentar();
            repository.save(d);
        }
    }
    
    public void pasarTiempo() {
        for (DinosaurioJpa d : repository.findAll()) {
            d.pasarTiempo();
            repository.save(d);
        }
    }
}