import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Vehiculo {
    private final String matricula;
    private final String modelo;
    private final CategoriaVehiculo categoria;
    private final int bateriaRestante;
    private final Set<Alquiler> historialAlquileres;

    public Vehiculo(String matricula, String modelo, CategoriaVehiculo categoria, int bateriaRestante) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.categoria = categoria;
        this.bateriaRestante = bateriaRestante;
        this.historialAlquileres = new HashSet<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCategoria() {
        return categoria.name();
    }

    public int getBateriaRestante() {
        return bateriaRestante;
    }

    public Set<Alquiler> getHistorialAlquileres() {
        return historialAlquileres;
    }


    public void agregarAlquiler(Alquiler alq) throws AlquilerDuplicadoException {
        if (!this.historialAlquileres.add(alq)) {
            throw new AlquilerDuplicadoException("El alquiler con ID " + alq.getIdAlquiler() + " ya está registrado.");
        }
    }

    public int obtenerDuracionTotalMinutos() {
        return this.historialAlquileres.stream()
                .mapToInt(Alquiler::getMinutosDuracion)
                .sum();
    }

    public double obtenerFacturacionTotal() {
        return this.historialAlquileres.stream()
                .mapToDouble(Alquiler::getCosteTotal)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}