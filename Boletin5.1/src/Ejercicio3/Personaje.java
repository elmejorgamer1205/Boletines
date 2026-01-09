package Ejercicio3;

import Exceptions.PersonajeException;

public class Personaje {

    /** Nombre del personaje */
    private String nombre;

    /** Raza del personaje (definida en un enum Raza) */
    private Raza raza;

    /** Nivel de fuerza del personaje (0-20) */
    private int fuerza;

    /** Nivel de inteligencia del personaje (0-20) */
    private int inteligencia;

    /** Vida máxima del personaje (no puede modificarse) */
    private final int VIDA_MAX;

    /** Vida actual del personaje */
    private int vidaActual;

    /**
     * Constructor de la clase Personaje.
     *
     * @param nombre Nombre del personaje
     * @param raza Raza del personaje en formato String
     * @param fuerza Nivel de fuerza (0-20)
     * @param inteligencia Nivel de inteligencia (0-20)
     * @param vidaMax Vida máxima del personaje (0-100)
     * @throws PersonajeException Si algún valor no es válido
     */
    public Personaje(String nombre, String raza, int fuerza, int inteligencia, int vidaMax)
            throws PersonajeException {

        // Asignamos el nombre
        this.nombre = nombre;

        // Asignamos la raza usando el metodo privado
        setRaza(raza);

        // Validamos y asignamos fuerza e inteligencia
        setFuerza(fuerza);
        setInteligencia(inteligencia);

        // Comprobamos que la vida máxima esté dentro del rango permitido
        if (vidaMax < 0 || vidaMax > 100) {
            throw new PersonajeException("La vida máxima introducida no es válida.");
        }

        // Inicializamos la vida máxima
        this.VIDA_MAX = vidaMax;

        // Al crear el personaje, su vida actual es la máxima
        this.vidaActual = VIDA_MAX;
    }

    /**
     * Asigna la raza al personaje.
     * Convierte el String a mayúsculas para que coincida con el enum Raza.
     *
     * @param raza Raza del personaje
     */
    private void setRaza(String raza) {
        this.raza = Raza.valueOf(raza.toUpperCase());
    }

    /**
     * Asigna la fuerza al personaje tras validarla.
     *
     * @param fuerza Nivel de fuerza
     * @throws PersonajeException Si la fuerza no está en el rango permitido
     */
    private void setFuerza(int fuerza) throws PersonajeException {
        if (fuerza < 0 || fuerza > 20) {
            throw new PersonajeException("La fuerza introducida no es válida");
        }
        this.fuerza = fuerza;
    }

    /**
     * Asigna la inteligencia al personaje tras validarla.
     *
     * @param inteligencia Nivel de inteligencia
     * @throws PersonajeException Si la inteligencia no está en el rango permitido
     */
    private void setInteligencia(int inteligencia) throws PersonajeException {
        if (inteligencia < 0 || inteligencia > 20) {
            throw new PersonajeException("La inteligencia introducida no es válida");
        }
        this.inteligencia = inteligencia;
    }

    /**
     * Modifica la vida actual del personaje.
     * Puede usarse para curar (valor positivo) o dañar (valor negativo).
     *
     * @param modificacion Cantidad de vida a modificar
     * @throws PersonajeException Si se supera la vida máxima
     */
    public void modificarVidaActual(int modificacion) throws PersonajeException {

        // Comprobamos que no se supere la vida máxima
        if (vidaActual + modificacion > VIDA_MAX) {
            throw new PersonajeException(
                    "Este personaje no puede ser curado, su vida está al máximo"
            );
        }
        // Aplicamos la modificación
        this.vidaActual += modificacion;
    }

    /**
     * Devuelve una representación en texto del personaje.
     *
     * @return Información del personaje en formato String
     */
    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", raza=" + raza +
                ", fuerza=" + fuerza +
                ", inteligencia=" + inteligencia +
                ", VIDA_MAX=" + VIDA_MAX +
                ", vidaActual=" + vidaActual +
                '}';
    }
}
