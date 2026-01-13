package Ejercicio3;

import Exceptions.PersonajeException;
import java.util.Arrays;

public class Mago extends Personaje {

    // Daño que realiza un hechizo (valor negativo porque resta vida)
    public static final int DAÑO = -10;

    // Tamaño máximo del array de hechizos que puede aprender un mago
    public static final int TAM_ARRAY_DE_HECHIZOS = 4;

    /*
     * Array que almacena los hechizos aprendidos por el mago.
     * Cada posición puede contener un hechizo o null.
     */
    private Hechizos[] hechizos;

    /**
     * Constructor de la clase Mago
     *
     * @param nombre Nombre del mago
     * @param raza Raza del mago
     * @param fuerza Fuerza del mago (máx. 15)
     * @param inteligencia Inteligencia del mago (mín. 17)
     * @param vidaMax Vida máxima del mago
     * @throws PersonajeException si no cumple los requisitos
     */
    public Mago(String nombre, String raza, int fuerza, int inteligencia, int vidaMax)
            throws PersonajeException {

        // Validación de la fuerza máxima permitida
        if (fuerza > 15) {
            throw new PersonajeException("Un mago no puede tener mas de 15 de fuerza");
        }

        // Validación de la inteligencia mínima requerida
        if (inteligencia < 17) {
            throw new PersonajeException("Un mago no puede tener menos de 17 de inteligencia");
        }

        // Llamada al constructor de la clase padre
        super(nombre, raza, fuerza, inteligencia, vidaMax);

        // Inicialización del array de hechizos
        hechizos = new Hechizos[TAM_ARRAY_DE_HECHIZOS];
    }

    /**
     * Permite al mago aprender un nuevo hechizo.
     *
     * @param hechizo Nombre del hechizo
     * @throws PersonajeException si ya no puede aprender más hechizos
     */
    public void aprenderHechizo(String hechizo) throws PersonajeException {

        // Se crea el nuevo hechizo
        Hechizos h = new Hechizos(hechizo);

        int contador = 0;

        // Contamos cuántos hechizos ya están aprendidos
        for (int i = 0; i < TAM_ARRAY_DE_HECHIZOS; i++) {
            if (hechizos[i] != null) {
                contador++;
            }
        }

        // Si el mago ya tiene el máximo de hechizos, lanza excepción
        if (contador == TAM_ARRAY_DE_HECHIZOS) {
            throw new PersonajeException("Este mago no puede aprender mas hechizos");
        }

        // Se guarda el hechizo en la primera posición libre
        for (int i = 0; i < TAM_ARRAY_DE_HECHIZOS; i++) {
            if (hechizos[i] == null) {
                hechizos[i] = h;
                return;
            }
        }
    }

    /**
     * Lanza un hechizo contra otro personaje.
     *
     * @param p Personaje objetivo
     * @param s Nombre del hechizo
     * @throws PersonajeException si el hechizo no existe o no se conoce
     */
    public void lanzarHechizos(Personaje p, String s) throws PersonajeException {

        // Recorremos el array de hechizos
        for (int i = 0; i < hechizos.length; i++) {
            if (hechizos[i] != null) {

                // Comprobamos si el nombre del hechizo coincide
                if (hechizos[i].getNombre().equalsIgnoreCase(s)) {
                    hechizos[i] = null; // El hechizo se consume
                    p.modificarVidaActual(DAÑO); // Se aplica el daño
                    return;
                }
            }
        }

        // Si no se encuentra el hechizo, se lanza excepción
        throw new PersonajeException("Ese hechizo no es válido o el mago no lo conoce");
    }

    /**
     * Muestra por pantalla los hechizos que conoce el mago.
     */
    public void mostrarHechizos() {

        // Recorremos el array y mostramos los hechizos no nulos
        for (int i = 0; i < hechizos.length; i++) {
            if (hechizos[i] != null) {
                System.out.println("· " + hechizos[i].getNombre());
            }
        }
    }

    /**
     * Devuelve una representación en texto del mago.
     *
     * @return String con la información del mago
     */
    @Override
    public String toString() {

        // TODO: Mejorar el formato de salida del array de hechizos
        return super.toString() + " Mago{" +
                "hechizos=" + Arrays.toString(hechizos) +
                '}';
    }
}


