public class SimuladorEstacionAlumnos {

    public static void main(String[] args) throws SimuladorException {
        System.out.println("=== INICIANDO SIMULADOR DE EMERGENCIA 'ANCIO VII' ===");

        // =======================================================================
        // PRUEBA DE CONTROL DE ERRORES: Validación de valores negativos
        // =======================================================================
        System.out.println("\n--- Probando control de errores de inicialización ---");
        try {
            // Se intenta crear un módulo de soporte vital con consumo y ocupantes en negativo
            ModuloEstacion moduloInvalido = new ModuloSoporteVital("Módulo Roto", -15.0, -3);
            System.out.println("[FALLO] Si ves este mensaje, no has controlado los valores negativos en el constructor.");
        } catch (SimuladorException e) {
            System.out.println("[CAPTURA EXCEPCIÓN] Correcto: Se ha lanzado y capturado SimuladorException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[FALLO] Se ha lanzado una excepción inesperada de tipo: " + e.getClass().getSimpleName());
        }

        // =======================================================================
        // SIMULACIÓN PRINCIPAL
        // =======================================================================

        // 1. Creación del Array de módulos (Polimorfismo de clase base)
        ModuloEstacion[] modulos = new ModuloEstacion[5];

        // 2. Inicialización de los módulos de prueba (Flujo normal)
        modulos[0] = new ModuloSoporteVital("Soporte Principal", 10.0, 4);
        modulos[1] = new ModuloSoporteVital("Camaras Criogenicas", 8.0, 30);
        modulos[2] = new ModuloLaboratorio("Laboratorio de Toxinas", 15.0, 5);
        modulos[3] = new ModuloLaboratorio("Cultivos Biologicos", 8.0, 2);
        modulos[4] = new ModuloPropulsion("Propulsor de Maniobra", 25.0, 250.0);

        // 3. Estado inicial antes del desastre
        System.out.println("\n--- ESTADO INICIAL DE LOS MÓDULOS ---");
        for (ModuloEstacion m : modulos) {
            String operativo = m.estaOperativo() ? "OPERATIVO" : "FUERA DE SERVICIO";
            System.out.println("- " + m.getNombre() + " | Energía: " + m.getEnergiaDisponible() + "% | Estado: " + operativo);
        }

        // 4. Fase de Alerta 1: Impacto y consumo severo (Factor de alerta 2.0)
        System.out.println("\n--- [ALERTA] ¡LLUVIA DE MICROMETEORITOS! APLICANDO FACTOR DE ALERTA 2.0 ---");
        for (ModuloEstacion m : modulos) {
            m.actualizarConsumo(2.0);
            System.out.println("- " + m.getNombre() + " ha actualizado su consumo. Energía restante: " + m.getEnergiaDisponible() + "%");
        }

        // 5. Fase de Alerta 2: Gestión de seguridad e interfaces (Polimorfismo de Interfaz)
        System.out.println("\n--- [SISTEMA] EJECUTANDO PROTOCOLOS DE SEGURIDAD AUTOMÁTICOS ---");
        for (ModuloEstacion m : modulos) {

            // =======================================================================
            // TODO POR EL ALUMNO:
            // 1. Comprobación de fuga de aire en módulos Presurizables:
            //    - Debes verificar de forma polimórfica si el módulo 'm' es Presurizable.
            //    - Si comprueba que tiene fuga de aire, debes despresurizar el módulo y mostrar un mensaje
            //      por pantalla con el formato: "[ALERTA] Fuga detectada en NOMBRE. ¡Módulo despresurizado de emergencia!"
            //    - Si no tiene fuga, muestra el mensaje: "[OK] Presión estable en modulo presurizable: NOMBRE"
            // =======================================================================

            if (m instanceof Presurizable){
                Presurizable p = (Presurizable) m;
                if (p.comprobarFugaAire()){
                    p.despresurizar();
                    System.out.println("[ALERTA] Fuga detectada en " + m.getNombre() + ". ¡Módulo despresurizado de emergencia!");
                }else {
                    System.out.println("[OK] Presión estable en modulo presurizable: " + m.getNombre());
                }
            }

            // =======================================================================
            // TODO POR EL ALUMNO:
            // 2. Activación de baterías de respaldo:
            //    - Debes verificar de forma polimórfica si el módulo 'm' posee BateriaRespaldo.
            //    - Si su energía disponible es menor al 50.0%, activa su sistema de respaldo de emergencia
            //      y muestra el mensaje por consola: "[SISTEMA] Activando baterías auxiliares en NOMBRE"
            // =======================================================================

            if (m instanceof BateriaRespaldo){
                if (m.getEnergiaDisponible() < 50.0){
                    BateriaRespaldo b = (BateriaRespaldo) m;
                    b.activarEnergiaEmergencia();
                    System.out.println("[SISTEMA] Activando baterías auxiliares en: " + m.getNombre());
                }
            }
        }

        // 6. Estado final de la estación espacial
        System.out.println("\n--- ESTADO DE LA ESTACIÓN AL FINALIZAR LA EMERGENCIA ---");
        int operativos = 0;
        for (ModuloEstacion m : modulos) {
            String operativo = m.estaOperativo() ? "OPERATIVO" : "SISTEMA CAÍDO";
            if (m.estaOperativo()) {
                operativos++;
            }
            System.out.println("- " + m.getNombre() + " | Energía final: " + m.getEnergiaDisponible() + "% | Estado: " + operativo);
        }

        System.out.println("\n>>> SIMULACIÓN TERMINADA. Módulos operativos salvados: " + operativos + "/5 <<<");
    }
}