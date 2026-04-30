package Boletin7_1.Ejercicio5;

// Importaciones de clases propias (probablemente utilidades hechas por ti o dadas en clase)
// para manejar la entrada por teclado y sus posibles errores de forma más limpia.
import Exception.MiEntradaSalidaException;
import io.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class Menu {
    public static void main(String[] args) {
        int opcion = 0;

        // Impresión del menú principal por consola.
        System.out.println("==========================================");
        System.out.println("           GESTIÓN DE FICHEROS            ");
        System.out.println("==========================================");
        System.out.println("1. Crear directorio");
        System.out.println("2. Crear fichero de texto");
        System.out.println("3. Borrar fichero de texto");
        System.out.println("4. Mostrar los ficheros que contiene una carpeta");
        System.out.println("5. Salir");
        System.out.println("==========================================");
        System.out.print("Elija una opción: ");

        try {
            // Bucle del menú: se repite hasta que el usuario elija la opción 5.
            while (opcion != 5) {
                // Utiliza tu clase personalizada para pedir un número del 1 al 5.
                opcion = MiEntradaSalida.leerEnteroRango("\n Opción: ", 1, 5);

                // Estructura switch moderna (introducida en Java 14) con flechas (->).
                // Es más limpia y no requiere la palabra reservada 'break' en cada caso.
                switch (opcion) {
                    case 1 -> crearDirectorio();
                    case 2 -> crearFichero();
                    case 3 -> borrarFichero();
                    case 4 -> mostrarFicheros();
                    case 5 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción no válida.");
                }
            }
        } catch (MiEntradaSalidaException e) {
            // Captura errores específicos de tu clase de utilidad (ej. si el usuario mete letras en vez de números).
            System.out.println(e.getMessage());
        }
    }

    public static void crearDirectorio() {
        // Pide el nombre de la carpeta
        String nombreDelDirectorio = MiEntradaSalida.leerLinea("Nombre: ");
        // Construye la ruta pasando las carpetas como parámetros separados.
        // Es más seguro que usar barras ("/"), ya que Java se adapta al sistema operativo (Windows/Linux/Mac).
        Path directorio = Path.of("src", "ejercicio5", "salidasEjercicio5", nombreDelDirectorio);

        try {
            // createDirectories crea el directorio y también todos los directorios padres si no existen.
            // (a diferencia de createDirectory, que fallaría si "salidasEjercicio5" no existiera previamente).
            Files.createDirectories(directorio);
            System.out.println("Creado!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void crearFichero() {
        String nombreDelFichero = MiEntradaSalida.leerLinea("Nombre: ");
        String cadenaContenidoFichero = MiEntradaSalida.leerLinea("Contenido: ");
        Path ruta = Path.of("src", "ejercicio5", "salidasEjercicio5", nombreDelFichero);

        try {
            // 🌟 ¡Muy bien aquí! Has incluido `+ System.lineSeparator()`.
            // Esto soluciona el problema del Ejercicio 4, garantizando que cada vez que añadas
            // texto, este termine con un salto de línea adecuado al sistema operativo.
            Files.writeString(ruta, cadenaContenidoFichero + System.lineSeparator(), StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void borrarFichero() {
        String nombreDelFichero = MiEntradaSalida.leerLinea("Nombre: ");
        Path ruta = Path.of("src", "ejercicio5", "salidasEjercicio5", nombreDelFichero);

        try {
            // deleteIfExists es muy útil porque devuelve 'true' si lo borró,
            // y no lanza excepción si el archivo no existía de antemano (a diferencia de Files.delete()).
            if (Files.deleteIfExists(ruta)) {
                System.out.println("Fichero borrado");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarFicheros() {
        // Ruta de la carpeta cuyo contenido queremos listar.
        Path ruta =  Path.of("src", "ejercicio5", "salidasEjercicio5");

        // Try-with-resources con Files.list(). Esto es vital porque Files.list abre
        // un flujo hacia el sistema de archivos que DEBE cerrarse.
        try(Stream<Path> lista = Files.list(ruta)){

            System.out.println("Archivos en "+ ruta.getFileName());

            // Itera sobre cada 'Path' dentro del Stream.
            // getFileName() extrae solo el nombre del archivo/carpeta final, ignorando toda la ruta absoluta.
            lista.forEach(p -> System.out.println(p.getFileName()));

        } catch (IOException e) {
            // Captura errores si, por ejemplo, la carpeta base no existe aún.
            System.out.println(e.getMessage());
        }
    }
}