package Boletin7_1.Ejercicio7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio7 {
    // Declaración del Scanner a nivel de clase para poder reutilizarlo en todos los métodos.
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;
        // Bucle do-while para mantener el menú activo hasta que se elija salir (opción 6).
        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            // Muy importante: Consumir el salto de línea residual después de leer un número (nextInt).
            // Esto evita que el próximo scanner.nextLine() se salte la lectura.
            scanner.nextLine();

            // Switch tradicional para manejar las opciones del menú.
            switch (opcion) {
                case 1:
                    System.out.println("Opción 1: Listar directorio");
                    opcion1();
                    break;
                case 2:
                    System.out.println("Opción 2: Listar con prefijo");
                    opcion2();
                    break;
                case 3:
                    System.out.println("Opción 3: Listar por extensión");
                    opcion3();
                    break;
                case 4:
                    System.out.println("Opción 4: Buscar archivo simple");
                    opcion4();
                    break;
                case 5:
                    System.out.println("Opción 5: Buscar recursivo");
                    // La vamos a utilizar con Files.walk
                    opcion5();
                    break;
                case 6:
                    System.out.println("¡Saliendo del programa!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
            System.out.println();
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ DE GESTIÓN DE DIRECTORIOS ===");
        System.out.println("1. Listar directorio");
        System.out.println("2. Listar directorio y buscar ficheros que comiencen por una palabra");
        System.out.println("3. Listar archivos con cierta extensión de un directorio");
        System.out.println("4. Buscar un archivo en un directorio");
        System.out.println("5. Buscar recursivamente un archivo en un directorio");
        System.out.println("6. Salir");
        System.out.println("=====================================");
    }

    public static void opcion1() {
        // ⚠️ NOTA: Este método está vacío.
        // Aquí deberías implementar un simple Files.list(p).forEach(...) similar a los otros métodos,
        // pero sin usar el .filter().
    }

    public static void opcion2() {
        System.out.println("Introduce el directorio: \n");
        Path p = Path.of(scanner.nextLine());

        System.out.println("Introduce por cual palabra quieres buscar");
        String palabraABuscar = scanner.nextLine();

        if (Files.isDirectory(p)) {
            // try-with-resources perfecto para cerrar el Stream.
            try (Stream<Path> ficheros = Files.list(p)) {

                // .filter(): Se queda solo con los archivos cuyo nombre (toString) empiece (startsWith) por la palabra.
                ficheros.filter(path -> path.getFileName().toString().startsWith(palabraABuscar))
                        .forEach(path -> {
                            // Comprueba si el elemento filtrado es directorio o archivo para formatear la salida.
                            if (Files.isDirectory(path)) {
                                System.out.printf("%s - directorio %n", path.getFileName());
                            } else {
                                try {
                                    System.out.printf("%s %.2f kb %n", path.getFileName(), Files.size(path) / 1024.0);
                                } catch (IOException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void opcion3() {
        System.out.println("Introduce el directorio: \n");
        Path p = Path.of(scanner.nextLine());

        System.out.println("Introduce por cual extension quieres buscar (sin el punto)");
        String extensionABuscar = scanner.nextLine();

        if (Files.isDirectory(p)) {
            try (Stream<Path> ficheros = Files.list(p)) {

                // .filter(): Se queda solo con los archivos cuyo nombre termine en (endsWith) un "." + la extensión.
                ficheros.filter(path -> path.getFileName().toString().endsWith("." + extensionABuscar))
                        .forEach(path -> {
                            if (Files.isDirectory(path)) {
                                System.out.printf("%s - directorio %n", path.getFileName());
                            } else {
                                try {
                                    System.out.printf("%s %.2f kb %n", path.getFileName(), Files.size(path) / 1024.0);
                                } catch (IOException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void opcion4() {
        System.out.println("Introduce el directorio: \n");
        Path p = Path.of(scanner.nextLine());

        System.out.println("Introduce el nombre del fichero que quieres buscar");
        String ficheroABuscar = scanner.nextLine();

        if (Files.isDirectory(p)) {
            // Files.find(): Es más avanzado que list().
            // Parámetro '1': Es la profundidad máxima (maxDepth). Como es 1, solo busca en esta carpeta, no entra en subcarpetas.
            // BiPredicate (path, atr): Expresión lambda que evalúa si el nombre del archivo coincide exactamente (equals).
            try (Stream<Path> ficheros = Files.find(p, 1, ((path, atr) -> {
                return path.getFileName().toString().equals(ficheroABuscar);
            }))) {
                ficheros.forEach(path -> {
                    if (Files.isDirectory(path)) {
                        System.out.printf("%s - directorio %n", path.getFileName());
                    } else {
                        try {
                            System.out.printf("%s %.2f kb %n", path.getFileName(), Files.size(path) / 1024.0);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void opcion5() {
        System.out.println("Introduce el directorio \n");
        Path p = Path.of(scanner.nextLine());

        System.out.println("Introduce el nombre del archivo a buscar");
        String archivoABuscar = scanner.nextLine();

        if (Files.isDirectory(p)) {
            // Files.walk(): A diferencia de list(), walk() es recursivo por defecto.
            // Entrará en todas las subcarpetas dentro del directorio indicado construyendo un árbol completo.
            try (Stream<Path> ficheros = Files.walk(p)) {

                // .filter(): Se queda con cualquier archivo/carpeta que contenga (contains) la palabra en cualquier parte de su nombre.
                ficheros.filter(path -> path.getFileName().toString().contains(archivoABuscar))
                        .forEach(path -> {
                            if (Files.isDirectory(path)) {
                                System.out.printf("%s - directorio %n", path.getFileName());
                            } else {
                                try {
                                    System.out.printf("%s %.2f kb %n", path.getFileName(), Files.size(path) / 1024.0);
                                } catch (IOException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}