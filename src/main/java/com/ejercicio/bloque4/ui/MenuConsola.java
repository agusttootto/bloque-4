package com.ejercicio.bloque4.ui;


import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.ejercicio.bloque4.model.Dinosaurio;
import com.ejercicio.bloque4.model.Empleado;
import com.ejercicio.bloque4.model.Visitante;

@RequiredArgsConstructor
public class MenuConsola {
    
    private final Scanner scanner = new Scanner(System.in);
    private final List<Dinosaurio> dinosaurios = new ArrayList<>();
    private final List<Visitante> visitantes = new ArrayList<>();
    private final List<Empleado> empleados = new ArrayList<>();
    private double ingresosTotales = 0;
    private double gastosTotales = 0;
    private final Random random = new Random();
    
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n========================================");
            System.out.println("    PARQUE TURÍSTICO DE DINOSAURIOS");
            System.out.println("========================================");
            System.out.println("1. Registrar dinosaurio");
            System.out.println("2. Alimentar dinosaurios");
            System.out.println("3. Registrar visitante");
            System.out.println("4. Vender entrada");
            System.out.println("5. Simular paso de tiempo");
            System.out.println("6. Ver estado del parque");
            System.out.println("7. Generar reporte");
            System.out.println("8. Salir");
            System.out.println("========================================");
            System.out.print("Opción: ");
            
            opcion = leerInt();
            
            switch (opcion) {
                case 1 -> registrarDinosaurio();
                case 2 -> alimentarDinosaurios();
                case 3 -> registrarVisitante();
                case 4 -> venderEntrada();
                case 5 -> simularPaso();
                case 6 -> verEstado();
                case 7 -> generarReporte();
                case 8 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 8);
    }
    
    private void registrarDinosaurio() {
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Tipo (CARNIVORO/HERBIVORO): ");
        String tipo = scanner.next().toUpperCase();
        
        Dinosaurio dino = new Dinosaurio(nombre, tipo);
        dinosaurios.add(dino);
        System.out.println("✅ Dinosaurio registrado: " + dino.getNombre());
    }
    
    private void alimentarDinosaurios() {
        if (dinosaurios.isEmpty()) {
            System.out.println("❌ No hay dinosaurios registrados");
            return;
        }
        
        for (Dinosaurio d : dinosaurios) {
            d.alimentar();
        }
        System.out.println("✅ Todos los dinosaurios han sido alimentados");
    }
    
    private void registrarVisitante() {
        System.out.print("Nombre del visitante: ");
        String nombre = scanner.next();
        
        Visitante v = new Visitante(nombre);
        visitantes.add(v);
        System.out.println("✅ Visitante registrado: " + v.getNombre());
    }
    
    private void venderEntrada() {
        if (visitantes.isEmpty()) {
            System.out.println("❌ No hay visitantes registrados");
            return;
        }
        
        System.out.println("Visitantes disponibles:");
        for (int i = 0; i < visitantes.size(); i++) {
            System.out.println(i + ". " + visitantes.get(i).getNombre());
        }
        
        System.out.print("Seleccione visitante: ");
        int idx = leerInt();
        
        if (idx >= 0 && idx < visitantes.size()) {
            Visitante v = visitantes.get(idx);
            double precioEntrada = 25.0;
            
            if (v.gastar(precioEntrada)) {
                ingresosTotales += precioEntrada;
                v.setZonaActual("Recinto Central");
                System.out.println("✅ Entrada vendida a " + v.getNombre());
            } else {
                System.out.println("❌ " + v.getNombre() + " no tiene suficiente dinero");
            }
        }
    }
    
    private void simularPaso() {
        System.out.println("\n🕐 Simulando paso de 1 hora...");
        
        // Dinosaurios pasan tiempo
        for (Dinosaurio d : dinosaurios) {
            d.pasarTiempo();
            
            // Evento: escape por hambre
            if (d.estaHambriento() && d.isEnRecinto()) {
                System.out.println("⚠️ " + d.getNombre() + " está hambriento!");
                
                if (random.nextInt(100) < 30) {
                    d.setEnRecinto(false);
                    System.out.println("💥 ¡" + d.getNombre() + " ESCAPÓ del recinto!");
                    gastosTotales += 1000; // Costo por captura
                    
                    // Posible ataque a visitante
                    if (!visitantes.isEmpty() && random.nextInt(100) < 50) {
                        Visitante v = visitantes.get(random.nextInt(visitantes.size()));
                        System.out.println("😱 ¡" + d.getNombre() + " atacó a " + v.getNombre() + "!");
                        gastosTotales += 500; // Gastos médicos
                    }
                }
            }
        }
        
        // Eventos aleatorios generales
        int evento = random.nextInt(100);
        
        if (evento < 8) {
            System.out.println("⚡ ¡APAGÓN MASIVO! La planta de energía falló");
            gastosTotales += 800;
        } else if (evento < 16) {
            System.out.println("🌧️ ¡TORMENTA TORRENCIAL! Visitantes se refugian");
        } else if (evento < 24) {
            System.out.println("🏷️ ¡HORA DE OFERTAS! Souvenirs al 50%");
            ingresosTotales += 300;
        } else if (evento < 30) {
            System.out.println("🚗 ¡FALLA DE VEHÍCULOS! Transporte detenido");
            gastosTotales += 400;
        }
        
        System.out.println("✅ Simulación completada");
    }
    
    private void verEstado() {
        System.out.println("\n========== ESTADO DEL PARQUE ==========");
        
        // Dinosaurios
        System.out.println("\n🦕 DINOSAURIOS (" + dinosaurios.size() + "):");
        for (Dinosaurio d : dinosaurios) {
            String estado = d.isEnRecinto() ? "🔒 En recinto" : "⚠️ ¡ESCAPÓ!";
            System.out.printf("   - %s (%s) | Hambre: %d%% | %s%n",
                d.getNombre(), d.getTipo(), d.getHambre(), estado);
        }
        
        // Visitantes
        System.out.println("\n👥 VISITANTES (" + visitantes.size() + "):");
        for (Visitante v : visitantes) {
            System.out.printf("   - %s | $%.2f | Zona: %s%n",
                v.getNombre(), v.getDinero(), v.getZonaActual());
        }
        
        // Empleados
        System.out.println("\n👨‍💼 EMPLEADOS (" + empleados.size() + "):");
        for (Empleado e : empleados) {
            System.out.printf("   - %s | %s | Zona: %s%n",
                e.getNombre(), e.getRol(), e.getZonaAsignada());
        }
        
        // Finanzas
        System.out.println("\n💰 FINANZAS:");
        System.out.printf("   Ingresos: $%.2f%n", ingresosTotales);
        System.out.printf("   Gastos: $%.2f%n", gastosTotales);
        System.out.printf("   Balance: $%.2f%n", ingresosTotales - gastosTotales);
        
        System.out.println("\n========================================");
    }
    
    private void generarReporte() {
        System.out.println("\n========== REPORTE GENERAL ==========");
        System.out.println("📅 Fecha: " + java.time.LocalDate.now());
        System.out.println("\n📊 ESTADÍSTICAS:");
        System.out.println("   - Dinosaurios: " + dinosaurios.size());
        System.out.println("   - Visitantes: " + visitantes.size());
        System.out.println("   - Empleados: " + empleados.size());
        
        long escapados = dinosaurios.stream().filter(d -> !d.isEnRecinto()).count();
        System.out.println("   - Dinosaurios escapados: " + escapados);
        
        System.out.println("\n💰 FINANZAS:");
        System.out.printf("   Ingresos totales: $%.2f%n", ingresosTotales);
        System.out.printf("   Gastos totales: $%.2f%n", gastosTotales);
        System.out.printf("   Balance neto: $%.2f%n", ingresosTotales - gastosTotales);
        
        System.out.println("\n=======================================");
    }
    
    private int leerInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    public void initEjemplo() {
        // Empleados iniciales
        empleados.add(new Empleado("Juan", "GUIA", "Recinto Central"));
        empleados.add(new Empleado("Maria", "SEGURIDAD", "Entrada"));
        empleados.add(new Empleado("Carlos", "MANTENIMIENTO", "Planta Energía"));
        
        // Dinosaurios iniciales
        dinosaurios.add(new Dinosaurio("Rex", "CARNIVORO"));
        dinosaurios.add(new Dinosaurio("Cera", "HERBIVORO"));
        dinosaurios.add(new Dinosaurio("Raptor", "CARNIVORO"));
        
        // Visitantes iniciales
        visitantes.add(new Visitante("Ana"));
        visitantes.add(new Visitante("Luis"));
        
        System.out.println("🎉 Parque inicializado con datos de ejemplo!");
    }
}