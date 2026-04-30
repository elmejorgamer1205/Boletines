package Boletin7_1.Ejercicio9;

import io.MiEntradaSalida; // Tu clase de utilidad para leer por teclado

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio9 {

    // 1. Añadido 'public' al main. ¡Perfecto para que la JVM lo ejecute sin problemas!
    public static void main(String[] args) {

        // Se pide al usuario el nombre del fichero a procesar
        String nombreFichero = MiEntradaSalida.leerLinea("Introduce el nombre del fichero: ");

        // Se define la ruta de entrada. Muy bien al unificar el nombre del paquete (Boletin7_1).
        Path pathEntrada = Path.of("src", "Boletin7_1", "Ejercicio9", nombreFichero);

        // Se define una ruta de salida dinámica, anteponiendo "resultado_" al nombre original
        Path pathSalida = Path.of("src", "Boletin7_1", "Ejercicio9", "resultado_" + nombreFichero);

        // Cláusula de guarda: si el fichero de entrada no existe o es una carpeta, cortamos la ejecución.
        if (!Files.exists(pathEntrada) || !Files.isRegularFile(pathEntrada)) {
            System.err.println("El fichero no existe o no es válido.");
            return;
        }

        // Abrimos el fichero de entrada con un Stream. El try-with-resources se encarga de cerrarlo al final.
        try (Stream<String> lineas = Files.lines(pathEntrada)) {

            // 2. Filtramos y recolectamos el resultado del Stream en una Lista
            // 3. La expresión regular busca un patrón específico (una palabra, espacio y una matrícula)
            List<String> lineasFiltradas = lineas
                    .filter(l -> l.matches("\\p{L}+\\s\\d{4}-[B-Z&&[^EIOU]]{3}"))
                    .toList(); // .toList() recoge todos los elementos que pasaron el filtro y los mete en una lista inmutable.

            // 4. Usamos Files.write para volcar toda la lista de golpe en el nuevo archivo.
            // Es mucho más eficiente que ir escribiendo línea a línea dentro de un bucle.
            Files.write(
                    pathSalida,
                    lineasFiltradas,
                    StandardOpenOption.CREATE, // Si "resultado_..." no existe, lo crea.
                    StandardOpenOption.TRUNCATE_EXISTING // ¡Gran decisión! Si ya existe de una ejecución anterior, lo sobrescribe desde cero, evitando que los datos se dupliquen.
            );

            // Mensaje de éxito
            System.out.println("Fichero procesado correctamente. Revisa: " + pathSalida.getFileName());

        } catch (IOException e) {
            // Captura de errores, usando System.err para imprimir en el canal de errores (suele salir en rojo en consola).
            System.err.println("Ocurrió un error de E/S: " + e.getMessage());
        }
    }
}