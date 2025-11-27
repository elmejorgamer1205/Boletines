package Ejercicio2;

import Exceptions.MontarPCException;
import utils.MiEntradaSalida;


public class MontarPC {
    public static void main(String[] args) throws InterruptedException {
        DiscoDuro discoDuro = null;
        Microprocesador microprocesador = null;
        PlacaBase placaBase = null;
        TarjetaGrafica tarjetaGrafica = null;

        System.out.println("¡Bienvenido al commprobador de piezas para tu nuevo ordenador!\n");
        System.out.println("Vamos a empezar con la Placa Base.");
        placaBase = crearPlacaBase();
        System.out.println("¡Muy bien! Ahora vamos con el Microprocesador. \n");
        microprocesador = crearMicroProcesador();
        System.out.println("¡Genial! Vamos ahora con la tarjeta gráfica. \n");
        tarjetaGrafica = crearTarjetaGrafica();
        System.out.println("¡Perfecto! Vamos con lo ultimo, el disco duro. \n");
        discoDuro = crearDiscoDuro();
        System.out.println("Vamos a hacer las comprobaciones necesarias. Espera un momento porfavor. \n");
        comprobar();
        try {
            placaBase.setMicroprocesador(microprocesador);
            System.out.println("\nTu ordenador esta listo. Asi ha quedado:");
            placaBase.componentes();
            System.out.println();
            microprocesador.componentes();
            System.out.println();
            tarjetaGrafica.componentes();
            System.out.println();
            discoDuro.componentes();

        } catch (MontarPCException e) {
            System.out.println(e.getMessage());
        }

    }


    public static PlacaBase crearPlacaBase(){
        String marca = MiEntradaSalida.leerLinea("Introduce la marca: \n");
        String chipset = MiEntradaSalida.leerLinea("Introduce el chipset: \n");
        String socket = MiEntradaSalida.leerLinea("Introduce el socket: \n");
        return new PlacaBase(marca,chipset,socket);
    }

    public static Microprocesador crearMicroProcesador(){
        String marca = MiEntradaSalida.leerLinea("Introduce la marca: \n");
        String modelo = MiEntradaSalida.leerLinea("Introduce el modelo: \n");
        int numNucleos = MiEntradaSalida.solicitarEnteroPositivo("Introduce el numero de nucleos: ", false);
        float velBase = MiEntradaSalida.solicitarFloat("Introduce la velocidad base: ");
        String socket = MiEntradaSalida.leerLinea("Introduce el socket: \n");
        return new Microprocesador(marca,modelo,numNucleos,velBase,socket);
    }

    public static TarjetaGrafica crearTarjetaGrafica(){
        String marca = MiEntradaSalida.leerLinea("Introduce la marca: \n");
        String modelo = MiEntradaSalida.leerLinea("Introduce el modelo: \n");
        int numNucleos = MiEntradaSalida.solicitarEnteroPositivo("Introduce el numero de nucleos: ",false);
        float velocidad = MiEntradaSalida.solicitarFloat("Introduce la velocidad: ");
        int capacidad = MiEntradaSalida.solicitarEntero("Introduce la capacidad en GB: ");
        return new TarjetaGrafica(marca,modelo,numNucleos,velocidad,capacidad);
    }

    public static DiscoDuro crearDiscoDuro(){
        String marca = MiEntradaSalida.leerLinea("Introduce la marca: \n");
        String tipo = MiEntradaSalida.leerLinea("Introduce el tipo: \n");
        int capacidad = MiEntradaSalida.solicitarEnteroPositivo("Introduce la capacidad del disco duro: ",false);
        return new DiscoDuro(marca,tipo,capacidad);
    }

    public static void comprobar() throws InterruptedException {
        int total = 50; // ancho de la barra

        for (int i = 0; i <= total; i++) {
            int porcentaje = (i * 100) / total;

            // Construir la barra con '=' para el progreso
            String barra = "[" +
                    "=".repeat(Math.max(0, i)) +
                    " ".repeat(Math.max(0, total - i)) +
                    "]";

            // Mostrar barra con porcentaje, usando \r para sobrescribir línea
            System.out.print("\r" + barra + " " + porcentaje + "%");

            Thread.sleep(100); // Simula tarea que toma tiempo
        }

        System.out.println("\nCarga completada.");

    }

}