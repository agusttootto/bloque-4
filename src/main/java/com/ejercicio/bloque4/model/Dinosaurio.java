package com.ejercicio.bloque4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dinosaurio {
    private Long id;
    private String nombre;
    private String tipo; // CARNIVORO, HERBIVORO
    private int hambre;
    private boolean enRecinto;

    // Constructor útil sin ID
    public Dinosaurio(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.hambre = 50;
        this.enRecinto = true;
    }

    // Métodos de negocio
    public void alimentar() {
        this.hambre = Math.max(0, this.hambre - 30);
    }

    public void pasarTiempo() {
        this.hambre = Math.min(100, this.hambre + 10);
    }

    public boolean estaHambriento() {
        return this.hambre > 70;
    }
}