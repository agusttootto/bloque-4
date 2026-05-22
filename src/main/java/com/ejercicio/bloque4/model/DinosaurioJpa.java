package com.ejercicio.bloque4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "dinosaurios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DinosaurioJpa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String tipo;
    
    @Column(nullable = false)
    @Builder.Default
    private Integer hambre = 50;
    
    @Column(name = "en_recinto")
    @Builder.Default
    private Boolean enRecinto = true;
    
    private String ubicacion;
    
    @Column(name = "created_at")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    
    public DinosaurioJpa(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.hambre = 50;
        this.enRecinto = true;
    }
    
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