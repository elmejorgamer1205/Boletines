package ejercicio2;

import Exceptions.VehiculoException;

public class FurgonetaDeCarga extends Vehiculo {

    /** Plus aplicado al precio de alquiler por cada unidad de PMA */
    public static final double PLUS_POR_PMA_FURGONETA = 0.5;

    /** Peso Máximo Autorizado de la furgoneta */
    private double PMA;

    /**
     * Constructor de la furgoneta de carga.
     *
     * @param gama tipo o gama del vehículo
     * @param matricula matrícula del vehículo
     * @param PMA Peso Máximo Autorizado
     * @param combustible tipo de combustible utilizado
     * @throws VehiculoException si el PMA es menor o igual a 0
     */
    public FurgonetaDeCarga(String gama, String matricula, double PMA, String combustible) throws VehiculoException {
        // Llama al constructor de Vehiculo
        super(gama, matricula, combustible);
        // Asigna y valida el PMA
        setPMA(PMA);
    }

    /**
     * Establece el PMA de la furgoneta.
     *
     * @param PMA Peso Máximo Autorizado
     * @throws VehiculoException si PMA <= 0
     */
    public void setPMA(double PMA) throws VehiculoException {
        if (PMA <= 0){
            throw new VehiculoException("La masa máxima autorizada debe ser mayor de 0");
        }
        this.PMA = PMA;
    }

    /**
     * Calcula el precio de alquiler del vehículo según los días.
     * Se añade un plus en función del PMA.
     *
     * @param dias número de días de alquiler
     * @return precio final del alquiler
     */
    @Override
    public double calcularAlquilerVehiculo(int dias) {
        // Calcula el precio base usando el método de la clase padre
        double precioFinal = super.calcularAlquilerVehiculo(dias);
        // Añade el plus por PMA
        precioFinal += PLUS_POR_PMA_FURGONETA * PMA;
        return precioFinal;
    }

    /**
     * Devuelve una representación en texto de la furgoneta de carga.
     *
     * @return información de la furgoneta en formato String
     */
    @Override
    public String toString() {
        return "FurgonetaDeCarga{" +
                "PMA=" + PMA +
                super.toString() + '}';
    }
}
