/**package Boletin6_1.Ejercicio3.main;

import Boletin6_1.Ejercicio3.models.Alumno;
import Boletin6_1.Ejercicio3.models.Profesor;

public class Principal {
        static void main(String[] args) {
            // 1. Crear personas
        Profesor profSeverus = new Profesor("Severus Snape", 45);
        Alumno alumnoHarry = new Alumno("Harry Potter", 17); // Menor de edad
        Alumno alumnoDraco = new Alumno("Draco Malfoy", 17); // Menor de edad
        Alumno alumnoHermione = new Alumno("Hermione Granger", 19); // Mayor de edad

        try {
            System.out.println("--- PRUEBAS DE ENVÍO ---");

            // Caso A: Profesor envía a Alumno (Permitido)
            profSeverus.enviarMensaje(alumnoHarry, "Ven a mi despacho.");

            // Caso B: Alumno mayor envía a Alumno (Permitido)
            alumnoHermione.enviarMensaje(alumnoDraco, "¿Has estudiado?");

            // Caso C: Alumno menor envía a Profesor (Permitido)
            alumnoHarry.enviarMensaje(profSeverus, "No podré asistir hoy.");

            // Caso D: Alumno menor intenta enviar a otro Alumno (ERROR esperado)
            System.out.println("Intento de envío: Harry (17) -> Draco (17)...");
            alumnoHarry.enviarMensaje(alumnoDraco, "Te veo en el patio.");

        } catch (Exception e) {
            System.out.println(">>> EXCEPCIÓN CAPTURADA: " + e.getMessage());
        }

        System.out.println("\n--- PRUEBAS DE LECTURA Y GESTIÓN (Buzón de Harry) ---");
        try {
            // Llenamos un poco el buzón de Harry para probar
            profSeverus.enviarMensaje(alumnoHarry, "Tarea pendiente de pociones.");
            Alumno alumnoRon = new Alumno("Ron Weasley", 19);
            alumnoRon.enviarMensaje(alumnoHarry, "Vamos a comer.");

            // 1. Leer mensajes
            System.out.println(alumnoHarry.leerMensajes());

            // 2. Leer ordenados (Ron debería salir antes que Severus alfabéticamente)
            System.out.println(alumnoHarry.leerMensajesOrdenados());

            // 3. Buscar mensaje
            System.out.println(alumnoHarry.buscarMensajes("pociones"));

            // 4. Borrar mensaje (Borramos el 1)
            alumnoHarry.borrarMensaje(1);
            System.out.println("Leemos de nuevo tras borrar:");
            System.out.println(alumnoHarry.leerMensajes());

            // 5. Buscar mensaje que no existe (Debe fallar)
            alumnoHarry.buscarMensajes("Quidditch");

        } catch (Exception e) {
            System.out.println(">>> EXCEPCIÓN CAPTURADA: " + e.getMessage());
        }
    }
}

**/