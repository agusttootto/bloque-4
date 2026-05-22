package com.ejercicio.bloque4.repository;

import com.ejercicio.bloque4.model.VisitanteJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VisitanteRepository extends JpaRepository<VisitanteJpa, Long> {
    
    // Buscar visitantes por zona actual
    List<VisitanteJpa> findByZonaActual(String zonaActual);
    
    // Buscar visitantes dentro del parque
    List<VisitanteJpa> findByDentroParqueTrue();
    
    // Buscar visitantes con dinero menor a cierto monto
    List<VisitanteJpa> findByDineroLessThan(double monto);
}