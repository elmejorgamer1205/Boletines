public class Main {

    // Añadimos 'throws AventureroException' a la firma de main para el flujo normal de las inserciones correctas
    public static void main(String[] args) throws AventureroException {
        System.out.println("=== INICIANDO PRUEBAS DE LA PLATAFORMA EL GRIFO DORADO ===");

        // Inicializamos el gremio limpio para el escenario óptimo
        Gremio gremio = new Gremio();

        System.out.println("Asignando misiones a los aventureros del Gremio...");

        // === AVENTURERO 0 (Queda con 2 misiones: 1 Caza, 1 Exploración) ===
        gremio.asignarMision(0, new Mision("M-101", TipoMision.CAZA, 400.0, 100.0));
        gremio.asignarMision(0, new Mision("M-102", TipoMision.EXPLORACION, 100.0, 50.0));

        // === AVENTURERO 1 (Queda con 2 misiones: 1 Caza, 1 Rescate) ===
        gremio.asignarMision(1, new Mision("M-201", TipoMision.CAZA, 300.0, 80.0));
        gremio.asignarMision(1, new Mision("M-202", TipoMision.RESCATE, 200.0, 300.0));

        // === AVENTURERO 2 (Queda con 2 misiones: 1 Caza, 1 Rescate) ===
        gremio.asignarMision(2, new Mision("M-301", TipoMision.CAZA, 250.0, 70.0));
        gremio.asignarMision(2, new Mision("M-302", TipoMision.RESCATE, 100.0, 400.0));


        // =======================================================================
        // PRUEBA DE CONTROL DE ERRORES 1: Validación de límites de aventureros
        // El gremio solo tiene 3 aventureros (índices 0, 1, 2).
        // Intentar meter el 'Aventurero 4' (índice 3 o superior) debe lanzar AventureroException.
        // =======================================================================
        System.out.println("\n--- Probando control de errores de indices ---");
        try {
            gremio.asignarMision(3, new Mision("M-X", TipoMision.EXPLORACION, 10.0, 10.0));
            System.out.println("[FALLO] Si ves este mensaje, no has lanzado tu excepcion 'AventureroException' ante indices incorrectos.");
        } catch (AventureroException e) {
            System.out.println("[CAPTURA EXCEPCIÓN] Correcto: Se ha lanzado y capturado AventureroException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[FALLO] Se ha lanzado una excepcion inesperada de tipo: " + e.getClass().getSimpleName());
        }


        // =======================================================================
        // PRUEBA DE CONTROL DE ERRORES 2: Capacidad máxima del Aventurero superada
        // Para evitar contaminar el estado de 'gremio', usamos una instancia temporal auxiliar
        // =======================================================================
        System.out.println("\n--- Probando control de errores de capacidad maxima (registro lleno) ---");
        Gremio gremioAuxiliarLlenado = new Gremio();
        try {
            // Llenamos el Aventurero 0 de este gremio auxiliar con 5 misiones normales
            gremioAuxiliarLlenado.asignarMision(0, new Mision("M-A1", TipoMision.EXPLORACION, 50.0, 10.0));
            gremioAuxiliarLlenado.asignarMision(0, new Mision("M-A2", TipoMision.EXPLORACION, 50.0, 10.0));
            gremioAuxiliarLlenado.asignarMision(0, new Mision("M-A3", TipoMision.EXPLORACION, 50.0, 10.0));
            gremioAuxiliarLlenado.asignarMision(0, new Mision("M-A4", TipoMision.EXPLORACION, 50.0, 10.0));
            gremioAuxiliarLlenado.asignarMision(0, new Mision("M-A5", TipoMision.EXPLORACION, 50.0, 10.0)); // 5ª misión (Lleno)

            // Este intento de inserción (el 6º) debe forzar el lanzamiento de AventureroException
            gremioAuxiliarLlenado.asignarMision(0, new Mision("M-A6", TipoMision.EXPLORACION, 80.0, 25.0));
            System.out.println("[FALLO] Si ves este mensaje, no has controlado con AventureroException cuando el aventurero esta lleno.");
        } catch (AventureroException e) {
            System.out.println("[CAPTURA EXCEPCIÓN] Correcto: Se ha lanzado y capturado AventureroException por registro lleno: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[FALLO] Se ha lanzado una excepcion inesperada en el llenado de tipo: " + e.getClass().getSimpleName());
        }


        // =======================================================================
        // PRUEBA 1: Escenario Óptimo (Se cumplen todas las condiciones con el gremio original)
        // Dificultad total: 1350 (> 1000)
        // Regla Caza: 1 exacta en cada aventurero
        // Regla Rescate: 700 oro en rescate vs 1000 oro total (> 50%)
        // =======================================================================

        System.out.println("\n--- PRUEBA 1: Escenario Óptimo ---");
        String resultado1 = gremio.iniciarExpedicionGlobal();
        System.out.println(resultado1);

        // SALIDA ESPERADA: "EXPEDICIÓN GLOBAL INICIADA... BUENA SUERTE"


        // =======================================================================
        // ZONA DE PRUEBAS ADICIONALES
        // Descomenta el bloque de código de abajo uno a uno para probar los fallos
        // =======================================================================


        // PRUEBA 2: Riesgo inminente (2 misiones de caza en un aventurero)
        System.out.println("\n--- PRUEBA 2: Riesgo de muerte ---");
        gremio.asignarMision(0, new Mision("M-103", TipoMision.CAZA, 50.0, 10.0));
        String resultado2 = gremio.iniciarExpedicionGlobal();
        System.out.println(resultado2);
        // SALIDA ESPERADA: "ERROR CRÍTICO: ¡RIESGO DE MUERTE INMINENTE!"



        // PRUEBA 3: Dificultad insuficiente (Reseteamos el gremio con misiones fáciles)
        System.out.println("\n--- PRUEBA 3: Dificultad insuficiente ---");
        Gremio gremioNovato = new Gremio();
        gremioNovato.asignarMision(0, new Mision("M-A", TipoMision.CAZA, 100.0, 100.0));
        gremioNovato.asignarMision(1, new Mision("M-B", TipoMision.CAZA, 100.0, 100.0));
        gremioNovato.asignarMision(2, new Mision("M-C", TipoMision.CAZA, 100.0, 100.0));
        String resultado3 = gremioNovato.iniciarExpedicionGlobal();
        System.out.println(resultado3);
        // SALIDA ESPERADA: "FALLO: Dificultad insuficiente para una expedición global"



        // PRUEBA 4: Estrategia desequilibrada (Hay dificultad, pero no cumplen ni Caza ni Rescate)
        System.out.println("\n--- PRUEBA 4: Estrategia desequilibrada ---");
        Gremio gremioCaos = new Gremio();
        gremioCaos.asignarMision(0, new Mision("M-X", TipoMision.EXPLORACION, 500.0, 100.0)); // No tiene caza
        gremioCaos.asignarMision(1, new Mision("M-Y", TipoMision.CAZA, 500.0, 100.0));
        gremioCaos.asignarMision(2, new Mision("M-Z", TipoMision.CAZA, 500.0, 100.0));
        String resultado4 = gremioCaos.iniciarExpedicionGlobal();
        System.out.println(resultado4);
        // SALIDA ESPERADA: "FALLO: Estrategia del gremio desequilibrada"

    }
}