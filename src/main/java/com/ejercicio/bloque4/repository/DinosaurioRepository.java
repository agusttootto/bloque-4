package com.ejercicio.bloque4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.bloque4.model.DinosaurioJpa;

import java.util.List;

@Repository
public interface DinosaurioRepository extends JpaRepository<DinosaurioJpa, Long> {

    // Buscar dinosaurios por tipo (CARNIVORO/HERBIVORO)
    List<DinosaurioJpa> findByTipo(String tipo); // ← Cambiado

    // Buscar dinosaurios que están en recinto
    List<DinosaurioJpa> findByEnRecintoTrue(); // ← Cambiado

    // Buscar dinosaurios hambrientos (hambre > 70)
    List<DinosaurioJpa> findByHambreGreaterThan(int hambre); // ← Cambiado
}