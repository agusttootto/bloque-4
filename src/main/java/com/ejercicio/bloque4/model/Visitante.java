package com.ejercicio.bloque4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visitante {
    private Long id;
    private String nombre;
    private Double dinero;
    private String zonaActual;
    private Boolean dentroParque;

    // Constructor útil
    public Visitante(String nombre) {
        this.nombre = nombre;
        this.dinero = 100.0;
        this.zonaActual = "Entrada";
        this.dentroParque = true;
    }

    public boolean gastar(double monto) {
        if (dinero >= monto) {
            dinero -= monto;
            return true;
        }
        return false;
    }
}