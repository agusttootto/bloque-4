package com.ejercicio.bloque4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {
    private Long id;
    private String nombre;
    private String rol;  // GUIA, SEGURIDAD, MANTENIMIENTO
    private String zonaAsignada;
    private Boolean activo;
    
    // Constructor útil
    public Empleado(String nombre, String rol, String zonaAsignada) {
        this.nombre = nombre;
        this.rol = rol;
        this.zonaAsignada = zonaAsignada;
        this.activo = true;
    }
}