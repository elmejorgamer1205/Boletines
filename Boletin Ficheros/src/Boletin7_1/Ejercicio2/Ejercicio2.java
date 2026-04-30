package Boletin7_1.Ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio2 {
    // Al igual que en el ejercicio anterior, faltaría el 'public' (public static void main)
    // para que sea un punto de entrada válido para ejecutar la aplicación.
    static void main(String[] args) {

        // Se define la ruta del archivo utilizando la API moderna java.nio
        Path p = Path.of("src/Boletin7_1/Ejercicio1/leeme.txt");

        // Bloque try-with-resources.
        // Abre el archivo y genera un Stream con sus líneas.
        // Hacerlo aquí dentro es la forma correcta y segura, ya que asegura que el Stream
        // (y el archivo subyacente) se cierre automáticamente al terminar.
        try(Stream<String> lineas = Files.lines(p)) {

            // lineas.collect() procesa el Stream completo.
            // Collectors.joining(" ") une todas las líneas leídas en un único String,
            // insertando un espacio en blanco (" ") entre cada línea, y lo imprime.
            System.out.println(lineas.collect(Collectors.joining(" ")));

        } catch(IOException e) {
            // Captura errores de lectura (por ejemplo, si la ruta está mal o el archivo no existe)
            // e imprime el motivo del error.
            System.out.println(e.getMessage());
        }

    }
}
