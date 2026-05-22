package com.ejercicio.bloque4.repository;

import com.ejercicio.bloque4.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    
    // Buscar empleados por rol
    List<Empleado> findByRol(String rol);
    
    // Buscar empleados activos
    List<Empleado> findByActivoTrue();
    
    // Buscar empleados por zona asignada
    List<Empleado> findByZonaAsignada(String zonaAsignada);
}