package com.ejercicio.bloque4.service;

import com.ejercicio.bloque4.model.Zona;
import com.ejercicio.bloque4.model.Visitante;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ZonaService {
    
    private final Map<String, Zona> zonas = new HashMap<>();
    
    public ZonaService() {
        // Inicializar las 5 zonas OBLIGATORIAS
        zonas.put("LUGAR_ARRIBO", new Zona("Lugar de Arribo", 50, 0.0));
        zonas.put("RECINTO_CENTRAL", new Zona("Recinto Central", 100, 0.0));
        zonas.put("BANIOS", new Zona("Baños", 10, 5.0));
        zonas.put("PLANTA_ENERGIA", new Zona("Planta de Energía", 5, 0.0));
        zonas.put("RECINTOS_OBSERVACION", new Zona("Recintos de Observación", 30, 15.0));
    }
    
    public boolean moverVisitante(Visitante visitante, String zonaNombre) {
        Zona nuevaZona = zonas.get(zonaNombre);
        Zona zonaActual = zonas.get(visitante.getZonaActual());
        
        if (nuevaZona == null) {
            System.out.println("❌ Zona no existe: " + zonaNombre);
            return false;
        }
        
        if (!zonaNombre.equals("PLANTA_ENERGIA") && !nuevaZona.getTieneEnergia()) {
            System.out.println("⚠️ " + zonaNombre + " no tiene energía disponible");
            return false;
        }
        
        if (!nuevaZona.hayEspacio()) {
            System.out.println("❌ " + zonaNombre + " está llena");
            return false;
        }
        
        if (nuevaZona.getTarifaExtra() > 0) {
            if (!visitante.gastar(nuevaZona.getTarifaExtra())) {
                System.out.println("❌ " + visitante.getNombre() + " no tiene suficiente dinero");
                return false;
            }
            System.out.println("💰 Pagó $" + nuevaZona.getTarifaExtra());
        }
        
        if (zonaActual != null) {
            zonaActual.salir();
        }
        
        nuevaZona.entrar();
        visitante.setZonaActual(zonaNombre);
        
        System.out.println("✅ " + visitante.getNombre() + " se movió a " + zonaNombre);
        return true;
    }
    
    public void mostrarEstadoZonas() {
        System.out.println("\n========== ESTADO DE ZONAS ==========");
        for (Zona zona : zonas.values()) {
            String energia = zona.getTieneEnergia() ? "⚡ Sí" : "❌ No";
            System.out.printf("📍 %s | %d/%d | Energía: %s | Tarifa: $%.2f%n",
                zona.getNombre(), zona.getTuristasActuales(), 
                zona.getCapacidadMaxima(), energia, zona.getTarifaExtra());
        }
    }
    
    public void fallaEnergia() {
        System.out.println("\n⚡ ¡FALLA ENERGÉTICA!");
        for (Zona zona : zonas.values()) {
            if (!zona.getNombre().equals("Planta de Energía")) {
                zona.setTieneEnergia(false);
            }
        }
    }
    
    public void restaurarEnergia() {
        for (Zona zona : zonas.values()) {
            zona.setTieneEnergia(true);
        }
        System.out.println("🔋 Energía restaurada");
    }
}