package EjercicioAvion;

import java.time.LocalDate;
import java.time.Period;

public class Registros {
    private LocalDate fecha;
    private boolean estado;
    private Period periodoDeValidez;

    public Registros(boolean estado, LocalDate fecha, Period periodoDeValidez) {
        this.estado = estado;
        this.fecha = fecha;
        this.periodoDeValidez = periodoDeValidez;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;

    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Period getPeriodoDeValidez() {
        return periodoDeValidez;
    }

    public void setPeriodoDeValidez(Period periodoDeValidez) {
        this.periodoDeValidez = periodoDeValidez;
    }

    public boolean isEstado() {
        return false;
    }
}
