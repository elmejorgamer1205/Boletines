import java.time.LocalDate;
import java.util.Objects;

public class Alquiler {
    private final String idAlquiler;
    private final String dniUsuario;
    private final int minutosDuracion;
    private final double costeTotal;
    private final LocalDate fechaServicio;

    public Alquiler(String idAlquiler, String dniUsuario, int minutosDuracion, double costeTotal, LocalDate fechaServicio) {
        this.idAlquiler = idAlquiler;
        this.dniUsuario = dniUsuario;
        this.minutosDuracion = minutosDuracion;
        this.costeTotal = costeTotal;
        this.fechaServicio = fechaServicio;
    }

    public String getIdAlquiler() {
        return idAlquiler;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public int getMinutosDuracion() {
        return minutosDuracion;
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public LocalDate getFechaServicio() {
        return fechaServicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alquiler alquiler = (Alquiler) o;
        return Objects.equals(idAlquiler, alquiler.idAlquiler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlquiler);
    }
}