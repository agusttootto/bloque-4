package com.ejercicio.bloque4.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.bloque4.service.TransaccionService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class DashboardController {
    
    private final TransaccionService transaccionService;
    
    @GetMapping
    public Map<String, BigDecimal> obtenerDashboard() {
        Map<String, BigDecimal> datos = new HashMap<>();
        datos.put("ingresos", transaccionService.totalIngresos());
        datos.put("gastos", transaccionService.totalGastos());
        datos.put("balance", transaccionService.balance());
        return datos;
    }
}