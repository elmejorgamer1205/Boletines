package Ejercicio3;

import Exceptions.PersonajeException;
import java.util.Arrays;

public class Mago extends Personaje {

    /** Daño que produce un hechizo (valor negativo porque resta vida) */
    public static final int DAÑO = -10;

    /** Tamaño máximo del array de hechizos que puede aprender un mago */
    public static final int TAM_ARRAY_DE_HECHIZOS = 4;

    /** Array que almacena los hechizos aprendidos por el mago */
    Hechizos[] hechizos = new Hechizos[TAM_ARRAY_DE_HECHIZOS];

    /**
     * Constructor de la clase Mago.
     * Aplica restricciones específicas para este tipo de personaje.
     *
     * @param nombre Nombre del mago
     * @param raza Raza del mago
     * @param fuerza Nivel de fuerza
     * @param inteligencia Nivel de inteligencia
     * @param vidaMax Vida máxima del mago
     * @throws PersonajeException Si no cumple las restricciones de un mago
     */
    public Mago(String nombre, String raza, int fuerza, int inteligencia, int vidaMax)
            throws PersonajeException {

        // Un mago no puede tener más de 15 de fuerza
        if (fuerza > 15) {
            throw new PersonajeException("Un mago no puede tener más de 15 de fuerza");
        }

        // Un mago no puede tener menos de 17 de inteligencia
        if (inteligencia < 17) {
            throw new PersonajeException("Un mago no puede tener menos de 17 de inteligencia");
        }

        // Llamada al constructor de la clase padre
        super(nombre, raza, fuerza, inteligencia, vidaMax);
    }

    /**
     * Permite al mago aprender un nuevo hechizo.
     *
     * @param hechizo Nombre del hechizo a aprender
     * @throws PersonajeException Si el mago ya conoce el máximo de hechizos
     */
    public void aprenderHechizo(String hechizo) throws PersonajeException {

        // Creamos un nuevo objeto Hechizos
        Hechizos h = new Hechizos(hechizo);

        int contador = 0;

        // Contamos cuántos hechizos tiene actualmente el mago
        for (int i = 0; i < TAM_ARRAY_DE_HECHIZOS; i++) {
            if (hechizos[i] != null) {
                contador++;
            }
        }

        // Si ya conoce el máximo de hechizos, lanzamos excepción
        if (contador == TAM_ARRAY_DE_HECHIZOS) {
            throw new PersonajeException("Este mago no puede aprender más hechizos");
        }

        // Guardamos el hechizo en la primera posición libre
        for (int i = 0; i < TAM_ARRAY_DE_HECHIZOS; i++) {
            if (hechizos[i] == null) {
                hechizos[i] = h;
                return;
            }
        }
    }

    /**
     * Permite al mago lanzar un hechizo contra otro personaje.
     *
     * @param p Personaje que recibe el daño
     * @param s Nombre del hechizo a lanzar
     * @throws PersonajeException Si el hechizo no existe o no lo conoce
     */
    public void lanzarHechizos(Personaje p, String s) throws PersonajeException {

        // Buscamos el hechizo en el array
        for (int i = 0; i < hechizos.length; i++) {

            // Comprobamos que la posición no esté vacía
            if (hechizos[i] != null) {

                // Comprobamos si el nombre del hechizo coincide
                if (hechizos[i].getNombre().equalsIgnoreCase(s)) {

                    // Eliminamos el hechizo tras usarlo
                    hechizos[i] = null;

                    // Aplicamos el daño al personaje objetivo
                    p.modificarVidaActual(DAÑO);
                    return;
                }
            }
        }

        // Si no se encuentra el hechizo, lanzamos excepción
        throw new PersonajeException("Ese hechizo no es válido o el mago no lo conoce");
    }

    /**
     * Devuelve una representación en texto del mago,
     * incluyendo sus hechizos aprendidos.
     *
     * @return Información del mago en formato String
     */
    @Override
    public String toString() {
        return super.toString() + " Mago{" +
                "hechizos=" + Arrays.toString(hechizos) +
                '}';
    }
}

