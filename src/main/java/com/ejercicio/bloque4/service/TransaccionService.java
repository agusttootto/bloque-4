package com.ejercicio.bloque4.service;

import com.ejercicio.bloque4.model.TransaccionJpa;
import com.ejercicio.bloque4.repository.TransaccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransaccionService {
    
    private final TransaccionRepository transaccionRepository;
    
    public List<TransaccionJpa> listarTodos() {
        return transaccionRepository.findAll();
    }
    
    public TransaccionJpa guardar(TransaccionJpa transaccion) {
        return transaccionRepository.save(transaccion);
    }
    
    public void registrarIngreso(String categoria, BigDecimal monto, String descripcion) {
        TransaccionJpa transaccion = TransaccionJpa.builder()
                .tipo("INGRESO")
                .categoria(categoria)
                .monto(monto)
                .descripcion(descripcion)
                .build();
        transaccionRepository.save(transaccion);
        System.out.printf("💰 INGRESO: $%.2f - %s%n", monto, descripcion);
    }
    
    public void registrarGasto(String categoria, BigDecimal monto, String descripcion) {
        TransaccionJpa transaccion = TransaccionJpa.builder()
                .tipo("GASTO")
                .categoria(categoria)
                .monto(monto)
                .descripcion(descripcion)
                .build();
        transaccionRepository.save(transaccion);
        System.out.printf("💸 GASTO: $%.2f - %s%n", monto, descripcion);
    }
    
    public BigDecimal totalIngresos() {
        BigDecimal total = transaccionRepository.sumarMontosPorTipo("INGRESO");
        return total != null ? total : BigDecimal.ZERO;
    }
    
    public BigDecimal totalGastos() {
        BigDecimal total = transaccionRepository.sumarMontosPorTipo("GASTO");
        return total != null ? total : BigDecimal.ZERO;
    }
    
    public BigDecimal balance() {
        return totalIngresos().subtract(totalGastos());
    }
}