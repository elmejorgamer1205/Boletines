package Examen2025;

/**
 * Representa un ataque en el sistema (posiblemente para un juego estilo Dragon Ball).
 * Implementa Comparable para permitir la ordenación de los ataques, por defecto, según su daño.
 */
public class Ataque implements Comparable<Ataque> {

    // Atributos inmutables (final) una vez inicializados.
    // Nota: En Java, las mayúsculas se suelen reservar para constantes estáticas (static final),
    // pero al ser 'final' es aceptable, aunque poco convencional para variables de instancia.
    private final int KI_NECESARIO;
    private final int PERFECCION_DEL_ATAQUE;
    private final int DAÑO;

    // Nombre del ataque. No es final, por lo que teóricamente podría cambiar
    // (aunque no hay un setter definido en esta clase).
    private String nombre;

    /**
     * Compara si dos objetos Ataque son iguales.
     * Se consideran iguales si tienen la misma perfección, el mismo daño y el mismo nombre.
     * El KI_NECESARIO no se evalúa para la igualdad.
     */
    @Override
    public final boolean equals(Object o) {
        // Si el objeto no es una instancia de Ataque, devuelve false.
        // Utiliza "pattern matching" de Java (ataque) para castear automáticamente.
        if (!(o instanceof Ataque ataque)) return false;

        // Compara los atributos clave.
        return PERFECCION_DEL_ATAQUE == ataque.PERFECCION_DEL_ATAQUE &&
                DAÑO == ataque.DAÑO &&
                nombre.equals(ataque.nombre);
    }

    /**
     * Genera un código hash único para el objeto.
     * Es obligatorio sobrescribirlo si se sobrescribe equals() para mantener el contrato entre ambos.
     */
    @Override
    public int hashCode() {
        int result = PERFECCION_DEL_ATAQUE;
        // El número 31 se usa tradicionalmente en Java porque es un primo impar,
        // lo que ayuda a distribuir mejor los hashes y evitar colisiones.
        result = 31 * result + DAÑO;
        result = 31 * result + nombre.hashCode();
        return result;
    }

    /**
     * Constructor de la clase Ataque.
     * * @param nombre Nombre del ataque.
     * @param kiNecesario Cantidad de Ki requerida (debe ser mayor a 0).
     * @param perfeccionDelAtaque Nivel de perfección (debe estar entre 1 y 3).
     * @param daño Puntos de daño que inflige (debe ser mayor a 0).
     * @throws DBException Si alguno de los valores proporcionados no cumple las reglas de negocio.
     */
    public Ataque(String nombre, int kiNecesario, int perfeccionDelAtaque, int daño) throws DBException {
        this.nombre = nombre;

        // Validaciones de negocio:
        if (kiNecesario <= 0) throw new DBException("El ki no es valido");
        this.KI_NECESARIO = kiNecesario;

        if (perfeccionDelAtaque < 1 || perfeccionDelAtaque > 3) throw new DBException("La perfección no es valida");
        this.PERFECCION_DEL_ATAQUE = perfeccionDelAtaque;

        if (daño <= 0) throw new DBException("EL daño no es válido");
        this.DAÑO = daño;
    }

    // --- GETTERS ---
    // Métodos para acceder a los atributos encapsulados (private).

    public int getKI_NECESARIO() {
        return KI_NECESARIO;
    }

    public int getPERFECCION_DEL_ATAQUE() {
        return PERFECCION_DEL_ATAQUE;
    }

    public int getDAÑO() {
        return DAÑO;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Define el criterio de ordenación natural de los objetos Ataque.
     * * @param o El otro ataque con el que se va a comparar.
     * @return un valor negativo si este ataque hace menos daño,
     * 0 si hacen el mismo daño,
     * o un valor positivo si este ataque hace más daño.
     */
    @Override
    public int compareTo(Ataque o) {
        // Ordena de menor a mayor daño.
        return this.DAÑO - o.DAÑO;
    }

    /**
     * Devuelve una representación en formato de cadena de texto del objeto.
     * Muy útil para depurar (debugging) o imprimir listas de ataques.
     */
    @Override
    public String toString() {
        // StringBuilder es más eficiente que concatenar strings con el operador '+'
        final StringBuilder sb = new StringBuilder("Ataque{");
        sb.append("KI_NECESARIO=").append(KI_NECESARIO);
        sb.append(", PERFECCION_DEL_ATAQUE=").append(PERFECCION_DEL_ATAQUE);
        sb.append(", DAÑO=").append(DAÑO);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}