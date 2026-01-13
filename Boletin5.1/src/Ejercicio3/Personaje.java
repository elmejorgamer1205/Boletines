package Ejercicio3;

import Exceptions.PersonajeException;

public class Personaje {

    // Nombre del personaje
    private String nombre;

    // Raza del personaje (enum Raza)
    private Raza raza;

    // Fuerza del personaje (0-20)
    private int fuerza;

    // Inteligencia del personaje (0-20)
    private int inteligencia;

    // Vida máxima del personaje (constante)
    private final int VIDA_MAX;

    // Vida actual del personaje
    private int vidaActual;

    /**
     * Constructor de la clase Personaje.
     *
     * @param nombre Nombre del personaje
     * @param raza Raza del personaje (String)
     * @param fuerza Fuerza del personaje
     * @param inteligencia Inteligencia del personaje
     * @param vidaMax Vida máxima del personaje
     * @throws PersonajeException si algún valor no es válido
     */
    public Personaje(String nombre, String raza, int fuerza,
                     int inteligencia, int vidaMax) throws PersonajeException {

        // Asignación del nombre
        this.nombre = nombre;

        // Conversión de la raza desde String a enum
        setRaza(raza);

        // Validación y asignación de fuerza e inteligencia
        setFuerza(fuerza);
        setInteligencia(inteligencia);

        /*
         * Validación de la vida máxima
         * Debe estar entre 0 y 100
         */
        if (vidaMax < 0 || vidaMax > 100) {
            throw new PersonajeException("La vida máxima introducida no es válida.");
        }

        // Inicialización de la vida
        this.VIDA_MAX = vidaMax;
        this.vidaActual = VIDA_MAX;
    }

    /**
     * Establece la raza del personaje a partir de un String.
     *
     * @param raza raza introducida por el usuario
     */
    private void setRaza(String raza) {

        // Convierte el String a enum Raza
        this.raza = Raza.valueOf(raza.toUpperCase());
    }

    /**
     * Establece la fuerza del personaje.
     *
     * @param fuerza valor de fuerza
     * @throws PersonajeException si la fuerza no es válida
     */
    private void setFuerza(int fuerza) throws PersonajeException {

        // Validación del rango de fuerza
        if (fuerza < 0 || fuerza > 20) {
            throw new PersonajeException("La fuerza introducida no es válida");
        }

        this.fuerza = fuerza;
    }

    /**
     * Establece la inteligencia del personaje.
     *
     * @param inteligencia valor de inteligencia
     * @throws PersonajeException si la inteligencia no es válida
     */
    private void setInteligencia(int inteligencia) throws PersonajeException {

        // Validación del rango de inteligencia
        if (inteligencia < 0 || inteligencia > 20) {
            throw new PersonajeException("La inteligencia introducida no es válida");
        }

        this.inteligencia = inteligencia;
    }

    /**
     * Modifica la vida actual del personaje.
     *
     * @param modificacion cantidad a sumar o restar
     * @throws PersonajeException si se intenta curar con la vida al máximo
     */
    public void modificarVidaActual(int modificacion) throws PersonajeException {

        // Evita que la vida supere la vida máxima
        if (vidaActual + modificacion > VIDA_MAX) {
            vidaActual = VIDA_MAX;
        }

        // Si la vida ya está al máximo, no se puede curar
        if (vidaActual == VIDA_MAX) {
            throw new PersonajeException(
                    "Este personaje no puede ser curado, su vida esta al máximo.");
        }

        // Se aplica la modificación
        this.vidaActual += modificacion;
    }

    /**
     * Devuelve el nombre del personaje.
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la vida actual del personaje.
     *
     * @return vida actual
     */
    public int getVidaActual() {
        return vidaActual;
    }

    /**
     * Compara dos personajes.
     * Dos personajes son iguales si tienen el mismo nombre y raza.
     *
     * @param o objeto a comparar
     * @return true si son iguales
     */
    @Override
    public boolean equals(Object o) {

        // Comprobación de null y tipo
        if (o == null || getClass() != o.getClass()) return false;

        // Conversión segura
        Personaje personaje = (Personaje) o;

        return nombre.equals(personaje.nombre) && raza == personaje.raza;
    }

    /**
     * Genera el código hash del personaje.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {

        int result = nombre.hashCode();
        result = 31 * result + raza.hashCode();
        return result;
    }

    /**
     * Devuelve una representación en texto del personaje.
     *
     * @return String con los datos del personaje
     */
    @Override
    public String toString() {

        // TODO: Mostrar solo información relevante para el jugador
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

