package Boletin7_1.Ejercicio8;

import io.MiEntradaSalida;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.stream.Stream;

public class Ejercicio8 {

    // De nuevo, recuerda el modificador 'public' para el main.
    static void main(String[] args) {

        // Pide al usuario el nombre del fichero a leer.
        String nombreFichero = MiEntradaSalida.leerLinea("Introduce el nombre del fichero: ");

        // Construye la ruta.
        // 💡 Pequeño detalle: fíjate que la carpeta se llama "Boletin7.1" aquí, pero tu paquete es "Boletin7_1".
        // Asegúrate de que el nombre de la carpeta sea exactamente igual al que tienes en tu disco.
        Path path = Path.of("src", "Boletin7.1", "Ejercicio8", nombreFichero);

        // Cláusula de guarda: Comprueba que el archivo exista y que además sea un archivo normal
        // (no un directorio ni un enlace simbólico).
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            // Imprime el error en rojo usando System.err (salida de error estándar).
            System.err.println("El fichero no existe o no es valido.");
            return; // Termina la ejecución del programa aquí mismo ("Early return").
        }

        // Abre el archivo línea a línea usando un Stream dentro de un try-with-resources para asegurar su cierre.
        try (Stream<String> lineas = Files.lines(path)) {

            // allMatch() es una operación terminal del Stream.
            // Comprueba si TODAS las líneas del archivo cumplen con la condición dada.
            // Si encuentra una sola línea que no cumpla, devuelve 'false' inmediatamente.
            boolean cumple = lineas.allMatch(l -> l.matches("(\\p{L}{2,}\\s){3}([1-9]|([1-9][0-9]))$"));

            // Muestra el resultado.
            if (cumple) System.out.println("cumple");
            else System.out.println("no cumple");

        } catch (IOException e) {
            // Captura errores de lectura del archivo.
            System.out.println(e.getMessage());
        }
    }
}