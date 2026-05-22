package com.ejercicio.bloque4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "eventos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoJpa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tipo_evento", nullable = false)
    private String tipoEvento;
    
    private String descripcion;
    
    @Column(name = "zona_afectada")
    private String zonaAfectada;
    
    @Builder.Default
    private LocalDateTime fecha = LocalDateTime.now();
    
    @Builder.Default
    private Boolean resuelto = false;
}