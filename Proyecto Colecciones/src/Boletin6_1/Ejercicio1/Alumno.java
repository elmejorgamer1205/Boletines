package Boletin6_1.Ejercicio1;

public class Alumno {

    // --- ATRIBUTOS ---
    private String nombre;
    // El ADN actúa como la clave principal o identificador único del alumno.
    private String adn;

    // --- CONSTRUCTOR ---
    /**
     * Crea un nuevo alumno.
     */
    public Alumno(String nombre, String adn) {
        this.nombre = nombre;
        this.adn = adn;
    }

    // --- GETTERS Y SETTERS ---
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAdn() {
        return adn;
    }

    public void setAdn(String adn) {
        this.adn = adn;
    }

    // --- MÉTODOS SOBRESCRITOS ---

    /**
     * Devuelve una representación en cadena de texto con los datos del alumno.
     */
    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", adn='" + adn + '\'' +
                '}';
    }

    /**
     * Determina si dos objetos Alumno son considerados "iguales".
     * Se ha declarado como 'final' para que, si se hereda de esta clase,
     * no se pueda cambiar la forma en la que se comparan los alumnos.
     */
    @Override
    public final boolean equals(Object o) {
        // Excelente uso del "Pattern Matching for instanceof" (introducido en Java 16).
        // Comprueba si 'o' es un Alumno y, de ser así, lo guarda en la variable 'alumno'.
        // Si no lo es, devuelve false directamente.
        if (!(o instanceof Alumno alumno)) return false;

        // La igualdad de dos alumnos depende EXCLUSIVAMENTE de que su ADN sea el mismo,
        // aunque tengan nombres diferentes (podría ser un cambio de nombre en el registro).
        return adn.equals(alumno.adn);
    }

    /**
     * Genera un código hash (un número entero) para el objeto.
     * Es OBLIGATORIO sobrescribir este método siempre que se sobrescribe equals().
     */
    @Override
    public int hashCode() {
        // El hashCode debe basarse en el mismo atributo que el equals (el ADN).
        // Esto garantiza que dos alumnos "iguales" terminen en el mismo "cubo"
        // si se guardan en un HashSet o HashMap.
        return adn.hashCode();
    }
}
