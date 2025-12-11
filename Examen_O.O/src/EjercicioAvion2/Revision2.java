package EjercicioAvion2;

import java.time.LocalDate;
import java.time.Period;

public class Revision2 {

    private LocalDate fecha;
    private boolean estado;
    private Period periodo;

    public Revision2(LocalDate fecha, Period periodo) {
        this.fecha = fecha;
        this.periodo = periodo;
        estaListo();
    }

    public void estaListo(){
        estado = !fecha.plus(periodo).isBefore(LocalDate.now());
    }

    public boolean isEstado() {
        return estado;
    }


}
