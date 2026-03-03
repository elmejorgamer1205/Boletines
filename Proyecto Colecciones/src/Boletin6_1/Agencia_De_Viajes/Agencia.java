package Boletin6_1.Agencia_De_Viajes;

import java.util.TreeMap;
import java.util.TreeSet;

public class Agencia {

    public static void main(String[] args) {

        // 1. Creamos la estructura de la Agencia para guardar a los clientes (ordenados por nombre)
        TreeMap<String, Cliente> listaClientes = new TreeMap<>();

        // 2. Creamos algunos clientes
        Cliente cliente1 = new Cliente("Ana", "C001");
        Cliente cliente2 = new Cliente("Carlos", "C002");
        Cliente cliente3 = new Cliente("Beatriz", "C003");

        listaClientes.put(cliente1.getNombre(), cliente1);
        listaClientes.put(cliente2.getNombre(), cliente2);
        listaClientes.put(cliente3.getNombre(), cliente3);

        // 3. Creamos algunas rutas (asumiendo que arreglaste el constructor a 2 parámetros)
        Ruta ruta1 = new Ruta("Tour Europa", "Roma");
        Ruta ruta2 = new Ruta("Escapada Ibérica", "Lisboa");
        Ruta ruta3 = new Ruta("Aventura Alpina", "Zúrich");

        System.out.println("=== INICIANDO PRUEBAS DE LA AGENCIA ===\n");

        try {
            // --- PRUEBA 1: Añadir rutas a los clientes ---
            cliente1.annadirRuta(ruta1);
            cliente1.annadirRuta(ruta2);
            cliente2.annadirRuta(ruta3);
            // cliente1.añadirRuta(ruta1); // Descomenta esta línea para probar la Excepción de ruta duplicada

            // --- PRUEBA 2: Añadir paradas a las rutas ---
            cliente1.annadirParadaRuta("Tour Europa", "Madrid");
            cliente1.annadirParadaRuta("Tour Europa", "París");
            cliente1.annadirParadaRuta("Tour Europa", "Barcelona");
            cliente1.annadirParadaRuta("Tour Europa", "Madrid"); // No se duplicará gracias al TreeSet

            cliente1.annadirParadaRuta("Escapada Ibérica", "Madrid");
            cliente1.annadirParadaRuta("Escapada Ibérica", "Oporto");

            cliente2.annadirParadaRuta("Aventura Alpina", "Milán");
            cliente2.annadirParadaRuta("Aventura Alpina", "Ginebra");

            // --- PRUEBA 3: Mostrar rutas de un cliente ---
            System.out.println("--- Rutas de Ana ---");
            System.out.println(cliente1.obtenerInfoRutas());

            // --- PRUEBA 4: Generar listado de clientes que pasan por una parada ---
            String paradaBuscada = "Madrid";
            System.out.println("--- Clientes con rutas que pasan por '" + paradaBuscada + "' ---");
            for (Cliente c : listaClientes.values()) {
                if (c.tieneParada(paradaBuscada)) {
                    System.out.println("- " + c.getNombre());
                }
            }

            // --- PRUEBA 5: Obtener TODAS las paradas de un cliente (sin duplicados y ordenadas) ---
            // Para esto, necesitarás un método en Cliente que junte todos los TreeSet de sus rutas en uno solo
            System.out.println("\n--- Todas las paradas únicas que visitará Ana ---");
            TreeSet<String> todasLasParadasAna = cliente1.obtenerTodasLasParadas();
            System.out.println(todasLasParadasAna);

            // --- PRUEBA 6: Eliminar una ruta ---
            System.out.println("\n--- Eliminando 'Escapada Ibérica' de Ana ---");
            cliente1.eliminarRuta("Escapada Ibérica");
            System.out.println(cliente1.obtenerInfoRutas());

        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ EXCEPCIÓN CAPTURADA: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("⚠️ ERROR INESPERADO: " + e.getMessage());
        }
    }
}
