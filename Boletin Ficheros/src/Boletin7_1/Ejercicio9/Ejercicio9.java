package Boletin7_1.Ejercicio9;

import io.MiEntradaSalida; // Asumo que esta clase es tuya y funciona correctamente

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio9 {

    // 1. Añadido 'public' al main
    public static void main(String[] args) {

        String nombreFichero = MiEntradaSalida.leerLinea("Introduce el nombre del fichero: ");

        // Cuidado: En tu código original ponía "Boletin7.1", pero el paquete es "Boletin7_1".
        // He unificado a "Boletin7_1", cámbialo si tu carpeta realmente tiene un punto.
        Path pathEntrada = Path.of("src", "Boletin7_1", "Ejercicio9", nombreFichero);

        // Creamos una ruta para el fichero de salida
        Path pathSalida = Path.of("src", "Boletin7_1", "Ejercicio9", "resultado_" + nombreFichero);

        if (!Files.exists(pathEntrada) || !Files.isRegularFile(pathEntrada)) {
            System.err.println("El fichero no existe o no es válido.");
            return;
        }

        try (Stream<String> lineas = Files.lines(pathEntrada)) {

            // 2. Filtramos y recolectamos el resultado del Stream en una Lista
            // 3. Se ha eliminado la barra '/' inicial de la expresión regular
            List<String> lineasFiltradas = lineas
                    .filter(l -> l.matches("\\p{L}+\\s\\d{4}-[B-Z&&[^EIOU]]{3}"))
                    .toList(); // Nota: .toList() requiere Java 16+. Si usas una versión anterior, usa .collect(Collectors.toList())

            // 4. Usamos Files.write (ideal para List<String>) con la ruta, el contenido y las opciones
            Files.write(
                    pathSalida,
                    lineasFiltradas,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING // Usamos TRUNCATE en lugar de APPEND para no duplicar si ejecutas 2 veces
            );

            System.out.println("Fichero procesado correctamente. Revisa: " + pathSalida.getFileName());

        } catch (IOException e) {
            System.err.println("Ocurrió un error de E/S: " + e.getMessage());
        }
    }
}