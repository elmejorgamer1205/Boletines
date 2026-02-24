package Boletin6_1.Ejercicio6;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Almacen almacen = new Almacen();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            String opcion = scanner.nextLine();

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
                    salir = true;
                    break;
                default:
                    System.out.println("Error: Opción no válida. Por favor, seleccione un número del 1 al 5.");
            }
        }
        scanner.close();
    }

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

    private static int pedirNumeroCaja() {
        while (true) {
            System.out.print("Introduce el número de caja (1-20): ");
            try {
                int numero = Integer.parseInt(scanner.nextLine());
                if (numero >= 1 && numero <= 20) {
                    return numero;
                } else {
                    System.out.println("Error: El número de caja debe estar entre 1 y 20.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, introduce un número válido.");
            }
        }
    }

    private static void abrirCaja() {
        int numero = pedirNumeroCaja();
        Caja caja = almacen.getCaja(numero);

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
        Caja mejorCaja = almacen.obtenerMejorCaja();

        if (mejorCaja == null) {
            System.out.println("Error: No hay ninguna caja abierta en este momento para atender al cliente.");
        } else {
            int numCliente = almacen.generarNuevoCliente();
            mejorCaja.agregarCliente(numCliente);
            System.out.println("Es usted el cliente número " + numCliente +
                    " y debe ir a la caja número " + mejorCaja.getNumero() + ".");
        }
    }

    private static void atenderCliente() {
        int numero = pedirNumeroCaja();
        Caja caja = almacen.getCaja(numero);

        if (!caja.isAbierta()) {
            System.out.println("Error: La caja " + numero + " está cerrada.");
        } else if (caja.getCantidadClientes() == 0) {
            System.out.println("Error: No hay clientes esperando en la caja " + numero + ".");
        } else {
            int clienteAtendido = caja.atenderCliente();
            System.out.println("Éxito: Se ha atendido al cliente con número " + clienteAtendido +
                    " en la caja " + numero + ".");
        }
    }
}
