import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   ENTORNO DE PRUEBAS - PLATAFORMA ECOVOLT       ");
        System.out.println("=================================================\n");

        PlataformaEcoVolt plataforma = new PlataformaEcoVolt();

        // =================================================================
        // 1. PRUEBA DE VEHÍCULOS Y AGREGAR ALQUILERES (CON EXCEPCIÓN)
        // =================================================================
        System.out.println("--- 1. Pruebas de Vehículo y Alquileres ---");

        Vehiculo patinete1 = new Vehiculo("PAT-01", "Xiaomi Pro 4", CategoriaVehiculo.PATINETE, 15);
        Vehiculo bici1 = new Vehiculo("BIC-01", "Orbea Urban", CategoriaVehiculo.BICICLETA, 40);
        Vehiculo coche1 = new Vehiculo("CAR-01", "Renault Twizy", CategoriaVehiculo.MICROCOCHE, 80);
        // Creamos un microcoche que se quedará sin vehículos en su categoría para forzar la excepción más adelante

        Alquiler alq1 = new Alquiler("ALQ-100", "12345678A", 20, 5.50, LocalDate.now());
        Alquiler alq2 = new Alquiler("ALQ-200", "87654321B", 45, 12.00, LocalDate.now());
        Alquiler alqDuplicado = new Alquiler("ALQ-100", "99999999Z", 10, 3.00, LocalDate.now()); // Mismo ID que alq1

        try {
            patinete1.agregarAlquiler(alq1);
            patinete1.agregarAlquiler(alq2);
            System.out.println("✅ Alquileres agregados correctamente a " + patinete1.getMatricula());

            // Forzar la excepción AlquilerDuplicadoException
            System.out.println("Intentando añadir un ID de alquiler duplicado...");
            patinete1.agregarAlquiler(alqDuplicado);
        } catch (AlquilerDuplicadoException e) {
            System.out.println("🎯 Excepción capturada con éxito: AlquilerDuplicadoException lanzada.");
        }

        // Añadimos datos de alquiler a la bicicleta para tener estadísticas variadas
        try {
            bici1.agregarAlquiler(new Alquiler("ALQ-300", "11112222C", 60, 18.50, LocalDate.now()));
        } catch (AlquilerDuplicadoException ignored) {}

        // Comprobación de métodos analíticos internos de Vehículo
        long minutosTotales = patinete1.obtenerDuracionTotalMinutos();
        double facturacionTotal = patinete1.obtenerFacturacionTotal();
        System.out.println("• Minutos totales de " + patinete1.getMatricula() + ": " + minutosTotales + " min.");
        System.out.println("• Facturación total de " + patinete1.getMatricula() + ": " + facturacionTotal + " €.");

        // =================================================================
        // 2. PRUEBA DE REGISTRO EN PLATAFORMA (CON EXCEPCIÓN)
        // =================================================================
        System.out.println("\n--- 2. Pruebas de Registro de Vehículos ---");
        try {
            plataforma.registrarVehiculo(patinete1);
            plataforma.registrarVehiculo(bici1);
            System.out.println("✅ Vehículos registrados en la plataforma.");

            // Forzar la excepción VehiculoDuplicadoException (Misma matrícula)
            System.out.println("Intentando registrar un vehículo con matrícula ya existente...");
            Vehiculo patineteClon = new Vehiculo("PAT-01", "Xiaomi Clon", CategoriaVehiculo.PATINETE, 100);
            plataforma.registrarVehiculo(patineteClon);
        } catch (VehiculoDuplicadoException e) {
            System.out.println("🎯 Excepción capturada con éxito: VehiculoDuplicadoException lanzada.");
        }

        // =================================================================
        // 3. PRUEBA DE BÚSQUEDA POR MATRÍCULA (OPTIONAL)
        // =================================================================
        System.out.println("\n--- 3. Pruebas de Búsqueda por Matrícula (Optional) ---");

        System.out.println("Buscando vehículo existente (BIC-01):");
        Optional<Vehiculo> busqueda1 = plataforma.buscarVehiculoPorMatricula("BIC-01");
        busqueda1.ifPresentOrElse(
                v -> System.out.println("✅ Encontrado: " + v.getModelo() + " [" + v.getCategoria() + "]"),
                () -> System.out.println("❌ No se encontró el vehículo.")
        );

        System.out.println("Buscando vehículo inexistente (FAKE-99):");
        Optional<Vehiculo> busqueda2 = plataforma.buscarVehiculoPorMatricula("FAKE-99");
        busqueda2.ifPresentOrElse(
                v -> System.out.println("❌ Encontrado inesperadamente: " + v.getModelo()),
                () -> System.out.println("✅ OK: El Optional regresó vacío correctamente.")
        );

        // =================================================================
        // 4. PRUEBA DE VEHÍCULOS BAJOS DE BATERÍA
        // =================================================================
        System.out.println("\n--- 4. Pruebas de Vehículos Bajos de Batería ---");
        // Tu código evalúa (bateriaRestante < umbralBateria)
        // patinete1 tiene 15, bici1 tiene 40. Si ponemos umbral 30, solo debe salir el patinete.
        System.out.println("Buscando vehículos con batería estrictamente menor a 30%:");
        Set<Vehiculo> criticos = plataforma.obtenerVehiculosBajosDeBateria(30);
        if (criticos.isEmpty()) {
            System.out.println("No hay vehículos bajos de batería.");
        } else {
            criticos.forEach(v -> System.out.println("⚠️ Alerta: " + v.getMatricula() + " - Batería: " + v.getBateriaRestante() + "%"));
        }

        // =================================================================
        // 5. PRUEBA DE FACTURACIÓN MEDIA POR CATEGORÍA (CON EXCEPCIÓN)
        // =================================================================
        System.out.println("\n--- 5. Pruebas de Facturación Media por Categoría ---");
        try {
            // Caso con éxito (PATINETE tiene a patinete1 con dos alquileres de 5.50 y 12.00. Total = 17.50 / 1 vehículo = 17.50)
            double mediaPatinete = plataforma.obtenerFacturacionMediaPorCategoria("PATINETE");
            System.out.println("✅ Facturación media en PATINETE: " + mediaPatinete + " €");

            // Caso de error: MICROCOCHE no tiene ningún vehículo registrado, por lo que el stream estará vacío
            // y saltará el .orElseThrow() de tu código.
            System.out.println("Intentando calcular la media de MICROCOCHE (sin vehículos)...");
            double mediaCoche = plataforma.obtenerFacturacionMediaPorCategoria("MICROCOCHE");
            System.out.println("Media: " + mediaCoche);
        } catch (EcoVoltException e) {
            System.out.println("🎯 Excepción capturada con éxito: EcoVoltException -> " + e.getMessage());
        }

        // =================================================================
        // 6. PRUEBA DE ORDENACIÓN DESCENDENTE DE FACTURACIÓN
        // =================================================================
        System.out.println("\n--- 6. Pruebas de Ordenación Descendente por Facturación ---");
        // Añadimos al coche a la plataforma con facturación alta para comprobar el orden real.
        try {
            coche1.agregarAlquiler(new Alquiler("ALQ-400", "22223333D", 100, 50.00, LocalDate.now()));
            plataforma.registrarVehiculo(coche1);
        } catch (Exception ignored) {}

        // Listar en orden descendente
        // Los totales son: CAR-01 (50.0€), BIC-01 (18.5€), PAT-01 (17.5€)
        System.out.println("Flota ordenada de mayor a menor ingresos:");
        List<Vehiculo> ordenados = plataforma.obtenerVehiculosOrdenadosPorFacturacionDescendente();
        for (Vehiculo v : ordenados) {
            System.out.println("• " + v.getMatricula() + " (" + v.getCategoria() + ") - Total: " + v.obtenerFacturacionTotal() + " €");
        }

        System.out.println("\n=================================================");
        System.out.println("      FIN DE LAS PRUEBAS COMPLETADO CON ÉXITO     ");
        System.out.println("=================================================");
    }
}