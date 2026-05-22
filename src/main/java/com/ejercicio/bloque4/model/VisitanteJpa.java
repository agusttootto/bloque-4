
package com.ejercicio.bloque4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "visitantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitanteJpa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    
    @Builder.Default
    private BigDecimal dinero = new BigDecimal("100.00");
    
    @Column(name = "zona_actual")
    @Builder.Default
    private String zonaActual = "Entrada";
    
    @Column(name = "dentro_parque")
    @Builder.Default
    private Boolean dentroParque = true;
    
    @Column(name = "created_at")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    
    public VisitanteJpa(String nombre) {
        this.nombre = nombre;
        this.dinero = new BigDecimal("100.00");
        this.zonaActual = "Entrada";
        this.dentroParque = true;
    }
    
    public boolean gastar(double monto) {
        BigDecimal montoBD = BigDecimal.valueOf(monto);
        if (dinero.compareTo(montoBD) >= 0) {
            dinero = dinero.subtract(montoBD);
            return true;
        }
        return false;
    }
}