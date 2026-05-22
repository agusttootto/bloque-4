package com.ejercicio.bloque4.repository;

import com.ejercicio.bloque4.model.EventoJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<EventoJpa, Long> {
    
    // Buscar eventos por tipo (ESCAPE, APAGON, etc.)
    List<EventoJpa> findByTipoEvento(String tipoEvento);
    
    // Buscar eventos no resueltos
    List<EventoJpa> findByResueltoFalse();
    
    // Buscar eventos por zona afectada
    List<EventoJpa> findByZonaAfectada(String zonaAfectada);
    
    // Buscar eventos por fecha
    List<EventoJpa> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);
}