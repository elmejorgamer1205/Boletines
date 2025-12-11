package EjercicioAvion;

import java.time.LocalDate;
import java.time.Period;

/**
 * Clase que representa un registro de revisión de un avión.
 * Incluye la fecha en la que se realizó, si fue aprobada,
 * y el periodo de validez de la revisión.
 */
public class Registros {

    /* Fecha en la que se realizó la revisión */
    private LocalDate fecha;

    /* Estado de la revisión: true = aprobada, false = no aprobada */
    private boolean estado;

    /* Periodo durante el cual la revisión sigue siendo válida */
    private Period periodoValidez;

    /**
     * Constructor que inicializa un registro de revisión.
     *
     * @param fecha fecha de realización de la revisión
     * @param estado estado de la revisión (válida o no)
     * @param periodoValidez periodo que define cuánto tiempo dura la validez
     */
    public Registros(LocalDate fecha, boolean estado, Period periodoValidez) {
        this.fecha = fecha;
        this.estado = estado;
        this.periodoValidez = periodoValidez;
    }

    /**
     * Representación en texto del registro.
     * Solo muestra el estado, no la fecha ni el periodo.
     */
    @Override
    public String toString() {
        return "Registro{" +
                "estado=" + estado +
                '}';
    }

    /**
     * Indica si la revisión está en estado válido.
     *
     * @return true si está aprobada, false si no lo está
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Devuelve el periodo durante el cual la revisión sigue siendo válida.
     *
     * @return periodo de validez
     */
    public Period getPeriodoValidez() {
        return periodoValidez;
    }

    /**
     * Devuelve la fecha en la que se realizó la revisión.
     *
     * @return fecha del registro
     */
    public LocalDate getFecha() {
        return fecha;
    }
}

