package Ejercicio3;

public class Hechizos {

    /** Nombre del hechizo (no puede modificarse) */
    private final String nombre;

    /**
     * Constructor de la clase Hechizos.
     *
     * @param nombre Nombre del hechizo
     */
    public Hechizos(String nombre) {
        // Asignamos el nombre del hechizo
        this.nombre = nombre;
    }

    /**
     * Devuelve el nombre del hechizo.
     *
     * @return Nombre del hechizo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve una representación en texto del hechizo.
     *
     * @return Información del hechizo en formato String
     */
    @Override
    public String toString() {
        return "Hechizo{" +
                "nombre='" + nombre + '\'' +
                "}";
    }
}
