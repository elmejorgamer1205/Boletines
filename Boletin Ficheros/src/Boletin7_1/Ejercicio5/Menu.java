package Boletin7_1.Ejercicio5;

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
            while (opcion != 5) {
                opcion = MiEntradaSalida.leerEnteroRango("\n Opción: ", 1, 5);

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
            System.out.println(e.getMessage());
        }

    }

    public static void crearDirectorio() {
        String nombreDelDirectorio = MiEntradaSalida.leerLinea("Nombre: ");
        Path directorio = Path.of("src", "ejercicio5", "salidasEjercicio5", nombreDelDirectorio);

        try {
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
            if (Files.deleteIfExists(ruta)) {
                System.out.println("Fichero borrado");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarFicheros(){
        Path ruta =  Path.of("src", "ejercicio5", "salidasEjercicio5");

        try(Stream<Path> lista = Files.list(ruta)){
            System.out.println("Archivos en "+ ruta.getFileName());
            lista.forEach(p -> System.out.println(p.getFileName()));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


}