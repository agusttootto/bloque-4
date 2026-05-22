package com.ejercicio.bloque4.repository;

import com.ejercicio.bloque4.model.TransaccionJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransaccionRepository extends JpaRepository<TransaccionJpa, Long> {
    
    // Buscar transacciones por tipo (INGRESO/GASTO)
    List<TransaccionJpa> findByTipo(String tipo);
    
    // Buscar transacciones por categoría
    List<TransaccionJpa> findByCategoria(String categoria);
    
    // Buscar transacciones por fecha
    List<TransaccionJpa> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);
    
    // Sumar montos por tipo
    @Query("SELECT SUM(t.monto) FROM Transaccion t WHERE t.tipo = ?1")
    BigDecimal sumarMontosPorTipo(String tipo);
}