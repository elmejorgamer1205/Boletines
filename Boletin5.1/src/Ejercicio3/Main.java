package Ejercicio3;

import Exceptions.PersonajeException;

public class Main {

    /**
     * Metodo principal del programa.
     * Punto de entrada de la aplicación.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        // Bloque try-catch para capturar posibles excepciones del programa
        try {

            // Creamos dos magos con distintos atributos
            Mago a = new Mago("Carlos", "humano", 14, 18, 100);
            Mago b = new Mago("Rubén", "enano", 15, 17, 85);

            // Creamos un clérigo con un dios asociado
            Clerigo c = new Clerigo("Álvaro", "humano", 18, 15, 100, "Zeus");

            // Mostramos el estado inicial de los personajes
            System.out.println(a.toString());
            System.out.println();
            System.out.println(b.toString());
            System.out.println();
            System.out.println(c.toString());
            System.out.println();

            // Separador visual en consola
            System.out.println("          Cambio               ");
            System.out.println();

            // Los magos aprenden hechizos
            a.aprenderHechizo("Doom");
            a.aprenderHechizo("Leviosa");
            b.aprenderHechizo("Freeze");

            // Mostramos el estado tras aprender hechizos
            System.out.println(a.toString());
            System.out.println();
            System.out.println(b.toString());
            System.out.println();

            // Nuevo separador visual
            System.out.println("          Cambio               ");
            System.out.println();

            // Los magos lanzan hechizos entre ellos
            a.lanzarHechizos(b, "Doom");
            b.lanzarHechizos(a, "Freeze");

            // El clérigo cura a uno de los magos
            c.curar(b);

            // Se lanza un último hechizo
            a.lanzarHechizos(b, "Leviosa");

            // Mostramos el estado final de los personajes
            System.out.println(a.toString());
            System.out.println();
            System.out.println(b.toString());
            System.out.println();

        } catch (PersonajeException e) {
            // Capturamos y mostramos el mensaje de error si ocurre una excepción
            System.out.println(e.getMessage());
        }
    }
}

