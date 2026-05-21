package com.ejercicio.bloque4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Zona {
    private Long id;
    private String nombre;
    private Integer capacidadMaxima;
    private Integer turistasActuales;
    private Double tarifaExtra;
    private Boolean tieneEnergia;
    
    public Zona(String nombre, int capacidadMaxima, double tarifaExtra) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.turistasActuales = 0;
        this.tarifaExtra = tarifaExtra;
        this.tieneEnergia = true;
    }
    
    public boolean hayEspacio() {
        return turistasActuales < capacidadMaxima;
    }
    
    public boolean entrar() {
        if (hayEspacio()) {
            turistasActuales++;
            return true;
        }
        return false;
    }
    
    public void salir() {
        if (turistasActuales > 0) {
            turistasActuales--;
        }
    }
}