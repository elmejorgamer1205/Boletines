import java.util.*;
import java.util.stream.Collectors;

public class PlataformaEcoVolt {

    private final Map<String, Set<Vehiculo>> flota;

    public PlataformaEcoVolt() {
        this.flota = new HashMap<>();
        this.flota.put("PATINETE", new HashSet<>());
        this.flota.put("BICICLETA", new HashSet<>());
        this.flota.put("MICROCOCHE", new HashSet<>());
    }

    public void registrarVehiculo(Vehiculo v) throws VehiculoDuplicadoException {
        String cat = v.getCategoria();


        boolean yaExiste = flota.values().stream()
                .flatMap(Set::stream)
                .anyMatch(vehiculo -> vehiculo.getMatricula().equalsIgnoreCase(v.getMatricula()));

        if (yaExiste) {
            System.out.println("El vehículo con matrícula " + v.getMatricula() + " ya está registrado.");
            throw new VehiculoDuplicadoException("Error de duplicidad de flota: " + v.getMatricula());
        }

        flota.computeIfAbsent(cat, k -> new HashSet<>()).add(v);
    }

    public Optional<Vehiculo> buscarVehiculoPorMatricula(String matricula) {
        return flota.values().stream()
                .flatMap(Set::stream)
                .filter(v -> v.getMatricula().equalsIgnoreCase(matricula))
                .findFirst();
    }

    public Set<Vehiculo> obtenerVehiculosBajosDeBateria(int umbralBateria) {
        return flota.values().stream()
                .flatMap(Set::stream)
                .filter(v -> v.getBateriaRestante() <= umbralBateria)
                .collect(Collectors.toSet());
    }

    public double obtenerFacturacionMediaPorCategoria(String categoria) throws EcoVoltException {
        String cat = categoria.toUpperCase();
        Set<Vehiculo> vehiculosCat = flota.get(cat);

        if (vehiculosCat == null || vehiculosCat.isEmpty()) {
            throw new EcoVoltException("No existen vehículos registrados en la categoría: " + categoria);
        }

        return vehiculosCat.stream()
                .mapToDouble(Vehiculo::obtenerFacturacionTotal)
                .average()
                .orElseThrow(() -> new EcoVoltException("Error al computar datos en " + categoria));
    }

    public List<Vehiculo> obtenerVehiculosOrdenadosPorFacturacionDescendente() {
        return flota.values().stream()
                .flatMap(Set::stream)
                .sorted(Comparator.comparingDouble(Vehiculo::obtenerFacturacionTotal).reversed())
                .collect(Collectors.toList());
    }
}
