package Ejercicio3;

import Exceptions.PersonajeException;

public class Clerigo extends Personaje {

    /** Cantidad de vida que puede curar un clérigo */
    public static final int CURACION = 10;

    /** Nombre del dios al que sirve el clérigo */
    private final String NOMBRE_DIOS;

    /**
     * Constructor de la clase Clerigo.
     * Aplica restricciones propias de este tipo de personaje.
     *
     * @param nombre Nombre del clérigo
     * @param raza Raza del clérigo
     * @param fuerza Nivel de fuerza (mínimo 18)
     * @param inteligencia Nivel de inteligencia (entre 12 y 16)
     * @param vidaMax Vida máxima del clérigo
     * @param nombreDios Nombre del dios al que sirve
     * @throws PersonajeException Si algún valor no es válido
     */
    public Clerigo(String nombre, String raza, int fuerza, int inteligencia,
                   int vidaMax, String nombreDios) throws PersonajeException {

        // Un clérigo debe tener al menos 18 de fuerza
        if (fuerza < 18) {
            throw new PersonajeException("Ese valor de fuerza no es válido");
        }

        // La inteligencia del clérigo debe estar entre 12 y 16
        if (inteligencia < 12 || inteligencia > 16) {
            throw new PersonajeException("Ese valor de inteligencia no es válido");
        }

        // Llamada al constructor de la clase padre
        super(nombre, raza, fuerza, inteligencia, vidaMax);

        // Asignamos el nombre del dios
        this.NOMBRE_DIOS = nombreDios;
    }

    /**
     * Cura a otro personaje.
     *
     * @param p Personaje al que se le restaura vida
     * @throws PersonajeException Si la curación supera la vida máxima
     */
    public void curar(Personaje p) throws PersonajeException {

        // Aplicamos la curación al personaje indicado
        p.modificarVidaActual(CURACION);
    }

    /**
     * Devuelve una representación en texto del clérigo,
     * incluyendo el nombre de su dios.
     *
     * @return Información del clérigo en formato String
     */
    @Override
    public String toString() {
        return super.toString() + " Clerigo{" +
                "NOMBRE_DIOS='" + NOMBRE_DIOS + '\'' +
                '}';
    }
}


