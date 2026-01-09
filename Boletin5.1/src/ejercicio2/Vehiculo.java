package ejercicio2;

import Exceptions.VehiculoException;

public abstract class Vehiculo {

    /** Gama del vehículo (Alta, Media o Baja) */
    private Gama gama;

    /** Matrícula del vehículo (inmutable) */
    private final String MATRICULA;

    /** Tipo de combustible del vehículo (inmutable) */
    private final Combustible TIPO_DE_COMBUSTIBLE;

    /**
     * Constructor de la clase Vehiculo.
     *
     * @param gama gama del vehículo ("Alta", "Media" o "Baja")
     * @param matricula matrícula del vehículo
     * @param combustible tipo de combustible ("Diesel" o "Gasolina")
     * @throws VehiculoException si la gama o el combustible no son válidos
     */
    public Vehiculo(String gama, String matricula, String combustible) throws VehiculoException {
        setGama(gama); // Valida y asigna la gama
        this.MATRICULA = matricula;

        // Valida y asigna el tipo de combustible
        try {
            this.TIPO_DE_COMBUSTIBLE = Combustible.valueOf(combustible.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new VehiculoException("Ese combustible no es válido");
        }
    }

    /**
     * Establece la gama del vehículo.
     *
     * @param gama gama del vehículo ("Alta", "Media", "Baja")
     * @throws VehiculoException si la gama no es válida
     */
    public void setGama(String gama) throws VehiculoException {
        try {
            this.gama = Gama.valueOf(gama.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new VehiculoException("Esa gama no es valida");
        }
    }

    /**
     * Devuelve el tipo de combustible del vehículo.
     *
     * @return tipo de combustible
     */
    public Combustible getTIPO_DE_COMBUSTIBLE() {
        return TIPO_DE_COMBUSTIBLE;
    }

    /**
     * Devuelve la gama del vehículo.
     *
     * @return gama
     */
    public Gama getGama() {
        return gama;
    }

    /**
     * Representación en texto del vehículo.
     *
     * @return información del vehículo en formato String
     */
    @Override
    public String toString() {
        return " " +
                "gama=" + gama +
                ", matricula=" + MATRICULA + '\'' +
                ", tipoDeCombustible=" + TIPO_DE_COMBUSTIBLE;
    }

    /**
     * Calcula el precio base de alquiler del vehículo en función
     * de los días de alquiler, la gama y el tipo de combustible.
     *
     * @param dias número de días de alquiler
     * @return precio final del alquiler
     */
    public double calcularAlquilerVehiculo(int dias) {
        double precioFinal = 0;

        // Añade el coste por gama
        precioFinal += getGama().getPRECIO() * dias;

        // Añade el coste por tipo de combustible
        precioFinal += getTIPO_DE_COMBUSTIBLE().getPrecio() * dias;

        return precioFinal;
    }
}

