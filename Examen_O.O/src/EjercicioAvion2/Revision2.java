package EjercicioAvion2;

import java.time.LocalDate;
import java.time.Period;

/**
 * Clase que representa una revisión con una fecha,
 * un periodo de validez y un estado que indica si sigue siendo válida.
 */
public class Revision2 {

    /* Fecha en la que se realizó la revisión */
    private LocalDate fecha;

    /* Estado de la revisión:
       true  = revisión válida
       false = revisión caducada */
    private boolean estado;

    /* Periodo de validez de la revisión */
    private Period periodo;

    /**
     * Constructor que inicializa la revisión con una fecha
     * y un periodo de validez. El estado se calcula automáticamente
     * llamando a estaListo().
     *
     * @param fecha fecha en la que se realizó la revisión
     * @param periodo tiempo durante el cual la revisión es válida
     */
    public Revision2(LocalDate fecha, Period periodo) {
        this.fecha = fecha;
        this.periodo = periodo;
        estaListo();  // Calcula el estado según la validez temporal
    }

    /**
     * Calcula si la revisión sigue siendo válida.
     * La revisión está válida si:
     *  fecha + periodo >= hoy
     */
    public void estaListo() {
        // La revisión es válida si la fecha + periodo NO ha quedado antes de hoy.
        estado = !fecha.plus(periodo).isBefore(LocalDate.now());
    }

    /**
     * Devuelve el estado actual de la revisión.
     *
     * @return true si es válida, false si está caducada
     */
    public boolean isEstado() {
        return estado;
    }
}


