package Boletin6_1.Ejercicio6;

import java.util.Scanner;

/**
 * Clase principal que contiene el metodo main y maneja la interfaz de usuario por consola.
 */
public class Main {
    // Variables estáticas porque se usan dentro del metodo estático main
    private static Scanner scanner = new Scanner(System.in);
    private static Almacen almacen = new Almacen(); // Instanciamos nuestro almacén

    public static void main(String[] args) {
        boolean salir = false;

        // Bucle infinito que mantiene el menú activo hasta que el usuario elija "Salir"
        while (!salir) {
            mostrarMenu();
            String opcion = scanner.nextLine();

            // Evaluamos la opción introducida por el usuario
            switch (opcion) {
                case "1":
                    abrirCaja();
                    break;
                case "2":
                    cerrarCaja();
                    break;
                case "3":
                    nuevoCliente();
                    break;
                case "4":
                    atenderCliente();
                    break;
                case "5":
                    System.out.println("Saliendo de la aplicación. ¡Hasta pronto!");
                    salir = true; // Cambiamos la condición para romper el bucle while
                    break;
                default:
                    System.out.println("Error: Opción no válida. Por favor, seleccione un número del 1 al 5.");
            }
        }
        scanner.close(); // Siempre es buena práctica cerrar el Scanner al terminar
    }

    // Muestra el menú por pantalla
    private static void mostrarMenu() {
        System.out.println("\n==============================");
        System.out.println(" GESTIÓN DE CAJAS DEL ALMACÉN ");
        System.out.println("==============================");
        System.out.println("1. Abrir caja");
        System.out.println("2. Cerrar caja");
        System.out.println("3. Nuevo cliente");
        System.out.println("4. Atender cliente");
        System.out.println("5. Salir");
        System.out.println("==============================");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Metodo auxiliar que pide al usuario un número y se asegura de que esté entre 1 y 20.
     * Repetirá la pregunta hasta que el usuario introduzca un dato válido.
     */
    private static int pedirNumeroCaja() {
        while (true) {
            System.out.print("Introduce el número de caja (1-20): ");
            try {
                int numero = Integer.parseInt(scanner.nextLine());
                if (numero >= 1 && numero <= 20) {
                    return numero; // Si es válido, lo devuelve y sale del bucle
                } else {
                    System.out.println("Error: El número de caja debe estar entre 1 y 20.");
                }
            } catch (NumberFormatException e) {
                // Captura el error si el usuario escribe letras en lugar de números
                System.out.println("Error: Por favor, introduce un número válido.");
            }
        }
    }

    // --- LÓGICA DE LAS OPCIONES DEL MENÚ ---

    private static void abrirCaja() {
        int numero = pedirNumeroCaja();
        Caja caja = almacen.getCaja(numero); // Solicitamos la caja al almacén

        // Comprobaciones antes de abrir
        if (caja.isAbierta()) {
            System.out.println("Error: La caja " + numero + " ya está abierta.");
        } else {
            caja.abrir();
            System.out.println("Éxito: Se ha abierto la caja " + numero + ".");
        }
    }

    private static void cerrarCaja() {
        int numero = pedirNumeroCaja();
        Caja caja = almacen.getCaja(numero);

        // Comprobaciones antes de cerrar (no puede estar cerrada ni tener clientes)
        if (!caja.isAbierta()) {
            System.out.println("Error: La caja " + numero + " ya está cerrada.");
        } else if (caja.getCantidadClientes() > 0) {
            System.out.println("Error: No se puede cerrar la caja " + numero +
                    " porque tiene " + caja.getCantidadClientes() + " clientes esperando.");
        } else {
            caja.cerrar();
            System.out.println("Éxito: Se ha cerrado la caja " + numero + ".");
        }
    }

    private static void nuevoCliente() {
        // Pedimos al almacén que calcule cuál es la mejor caja (la más vacía)
        Caja mejorCaja = almacen.obtenerMejorCaja();

        if (mejorCaja == null) {
            System.out.println("Error: No hay ninguna caja abierta en este momento para atender al cliente.");
        } else {
            // Generamos el ticket y metemos al cliente en la caja elegida
            int numCliente = almacen.generarNuevoCliente();
            mejorCaja.agregarCliente(numCliente);
            System.out.println("Es usted el cliente número " + numCliente +
                    " y debe ir a la caja número " + mejorCaja.getNumero() + ".");
        }
    }

    private static void atenderCliente() {
        int numero = pedirNumeroCaja();
        Caja caja = almacen.getCaja(numero);

        // Comprobaciones antes de atender
        if (!caja.isAbierta()) {
            System.out.println("Error: La caja " + numero + " está cerrada.");
        } else if (caja.getCantidadClientes() == 0) {
            System.out.println("Error: No hay clientes esperando en la caja " + numero + ".");
        } else {
            // Sacamos al cliente de la cola de la caja
            int clienteAtendido = caja.atenderCliente();
            System.out.println("Éxito: Se ha atendido al cliente con número " + clienteAtendido +
                    " en la caja " + numero + ".");
        }
    }
}