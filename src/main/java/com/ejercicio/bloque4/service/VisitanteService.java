package com.ejercicio.bloque4.service;

import com.ejercicio.bloque4.model.VisitanteJpa;
import com.ejercicio.bloque4.repository.VisitanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitanteService {
    
    private final VisitanteRepository visitanteRepository;
    
    public List<VisitanteJpa> listarTodos() {
        return visitanteRepository.findAll();
    }
    
    public VisitanteJpa guardar(VisitanteJpa visitante) {
        return visitanteRepository.save(visitante);
    }
    
    public VisitanteJpa buscarPorId(Long id) {
        return visitanteRepository.findById(id).orElse(null);
    }
    
    public void eliminar(Long id) {
        visitanteRepository.deleteById(id);
    }
    
    public long contar() {
        return visitanteRepository.count();
    }
}