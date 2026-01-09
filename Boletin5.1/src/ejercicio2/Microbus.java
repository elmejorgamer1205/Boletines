package ejercicio2;

import Exceptions.VehiculoException;

public class Microbus extends Vehiculo {

    /** Plus aplicado al precio de alquiler por cada plaza del microbús */
    public static final double PLUS_POR_PLAZA_MINIBUS = 5;

    /** Número de plazas del microbús */
    private int numPLazas;

    /**
     * Constructor de la clase Microbus.
     *
     * @param gama tipo o gama del vehículo
     * @param matricula matrícula del vehículo
     * @param combustible tipo de combustible utilizado
     * @param numPLazas número de plazas del microbús
     * @throws VehiculoException si el número de plazas es menor o igual a 0
     */
    public Microbus(String gama, String matricula, String combustible, int numPLazas) throws VehiculoException {
        // Llamada al constructor de la clase padre Vehiculo
        super(gama, matricula, combustible);
        // Asignación y validación del número de plazas
        setNumPLazas(numPLazas);
    }

    /**
     * Establece el número de plazas del microbús.
     *
     * @param numPLazas número de plazas
     * @throws VehiculoException si numPLazas <= 0
     */
    public void setNumPLazas(int numPLazas) throws VehiculoException {
        if (numPLazas <= 0) {
            throw new VehiculoException("No puede tener 0 o menos plazas");
        }
        this.numPLazas = numPLazas;
    }

    /**
     * Calcula el precio de alquiler del microbús según los días.
     * Se añade un plus en función del número de plazas.
     *
     * @param dias número de días de alquiler
     * @return precio final del alquiler
     */
    @Override
    public double calcularAlquilerVehiculo(int dias) {
        // Calcula el precio base usando el metodo de la clase padre
        double precioFinal = super.calcularAlquilerVehiculo(dias);
        // Añade el plus por plazas
        precioFinal += numPLazas * PLUS_POR_PLAZA_MINIBUS;
        return precioFinal;
    }

    /**
     * Devuelve una representación en texto del microbús.
     *
     * @return información del microbús en formato String
     */
    @Override
    public String toString() {
        return "Microbus{" +
                "numPLazas=" + numPLazas +
                super.toString() + '}';
    }
}

