package Boletin7_1.Ejercicio7;

import java.nio.file.Path;

public class Ejercicio7 {
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Opción 2: Listar con prefijo");
                    break;
                case 2:
                    System.out.println("Opción 3: Listar por extensión");
                    break;
                case 3:
                    System.out.println("Opción 4: Buscar archivo simple");
                    break;
                case 4:
                    System.out.println("Opción 5: Buscar recursivo");
                    break;
                case 5:
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

    public static void opcion1(){
        System.out.println("Introduce el directorio: \n");
        Path p = Path.of()
    }
}
