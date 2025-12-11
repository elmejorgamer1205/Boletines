package EjercicioAvion;

import java.time.LocalDate;
import java.time.Period;

public class Registros {
    private LocalDate fecha;
    private boolean estado;
    private Period periodoValidez;

    public Registros(LocalDate fecha, boolean estado, Period periodoValidez) {
        this.fecha = fecha;
        this.estado = estado;
        this.periodoValidez = periodoValidez;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "estado=" + estado +
                '}';
    }

    public boolean isEstado() {
        return estado;
    }

    public Period getPeriodoValidez() {
        return periodoValidez;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
