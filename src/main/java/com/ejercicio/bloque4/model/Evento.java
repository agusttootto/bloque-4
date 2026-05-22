package com.ejercicio.bloque4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evento {
    private Long id;
    private String tipoEvento;
    private String descripcion;
    private String zonaAfectada;
    private LocalDateTime fecha;
    private Boolean resuelto;
    
    public Evento(String tipoEvento, String descripcion, String zonaAfectada) {
        this.tipoEvento = tipoEvento;
        this.descripcion = descripcion;
        this.zonaAfectada = zonaAfectada;
        this.fecha = LocalDateTime.now();
        this.resuelto = false;
    }
}