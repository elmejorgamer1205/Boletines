/**
 * Esta clase representa a los aventureros que completaran ciertas misiones.
 * Es capaz de almacenar un máximo de 5 misiones.
 */

public class Aventurero {

    //Array para almacenar 5 misiones
    private Mision[] misiones;

    /**
     * Constructor por defecto.
     * Inicializa el array reservando espacio para 5 elementos.
     */
    public Aventurero() {
        this.misiones = new Mision[5];
    }

    /**
     * Intenta añadir una misión al array en la primera posición que encuentre vacía
     * @param m La misión que va a añadir.
     * @return true si se añadió correctamente, false si el depósito está lleno.
     */
    public boolean agregarMision(Mision m) {
        for (int i = 0; i < misiones.length; i++) {
            if (misiones[i] == null) {
                misiones[i] = m;
                return true;
            }
        }
        return false;
    }

    /**
     * Calcula la dificultad que tendrá la misión
     * @return la dificultad de la misión
     */
    public double calcularDificultadTotal() {
        double total = 0;
        for (Mision m : misiones) {
            if (m != null) {
                total += m.getDificultad();
            }
        }
        return total;
    }

    /**
     * Calcula el valor de la recompensa que tendrá la misión
     * @return el valor de la recompensa de la misión
     */
    public double calcularRecompensaTotal() {
        double total = 0;
        for (Mision m : misiones) {
            if (m != null) {
                total += m.getRecompensa();
            }
        }
        return total;
    }

    /**
     * Cuenta el número de misiones que hay.
     * @param tipo El tipo de misión
     * @return El número de misiones
     */
    public int contarMisionesDeTipo(TipoMision tipo) {
        int contador = 0;
        for (Mision m : misiones) {
            if (m != null && m.getTipo() == tipo) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Calcula el valor de la recompensa que tendrá la misión según el tipo de misión que sea.
     * @return el valor de la recompensa de la misión según la misión
     */
    public double calcularRecompensaMisionTipo(TipoMision tipo) {
        double total = 0;
        for (Mision m : misiones) {
            if (m != null && m.getTipo() == tipo) {
                total += m.getRecompensa();
            }
        }
        return total;
    }
}
