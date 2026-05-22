package com.ejercicio.bloque4.repository;

import com.ejercicio.bloque4.model.ZonaJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ZonaRepository extends JpaRepository<ZonaJpa, Long> {
    
    // Buscar zona por nombre
    Optional<ZonaJpa> findByNombre(String nombre);
    
    // Buscar zonas con energía disponible
    List<ZonaJpa> findByTieneEnergiaTrue();
    
    // Buscar zonas sin energía
    List<ZonaJpa> findByTieneEnergiaFalse();
}