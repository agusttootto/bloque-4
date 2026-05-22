package com.ejercicio.bloque4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaccion {
    private Long id;
    private String tipo;
    private String categoria;
    private BigDecimal monto;
    private String descripcion;
    private LocalDateTime fecha;
    
    public Transaccion(String tipo, String categoria, BigDecimal monto, String descripcion) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
    }
}