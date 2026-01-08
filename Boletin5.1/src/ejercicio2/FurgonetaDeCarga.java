package ejercicio2;

import Exceptions.VehiculoException;

public class FurgonetaDeCarga extends Vehiculo{
    public static final double PLUS_POR_PMA_FURGONETA = 0.5;
    private double PMA;


    public FurgonetaDeCarga(String gama, String matricula, double PMA, String combustible) throws VehiculoException {
        super(gama, matricula, combustible);
        setPMA(PMA);
    }

    public void setPMA(double PMA) throws VehiculoException {
        if (PMA <= 0){
            throw new VehiculoException("La masa máxima autorizada debe ser mayor de 0");
        }
        this.PMA = PMA;
    }

    @Override
    public double calcularAlquilerVehiculo(int dias) {
        double precioFinal = super.calcularAlquilerVehiculo(dias);
        precioFinal += PLUS_POR_PMA_FURGONETA * PMA;
        return precioFinal;
    }

    @Override
    public String toString() {
        return "FurgonetaDeCarga{" +
                "PMA=" + PMA +
                super.toString()+'}';
    }
}