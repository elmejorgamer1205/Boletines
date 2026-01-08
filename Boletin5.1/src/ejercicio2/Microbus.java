package ejercicio2;

import Exceptions.VehiculoException;

public class Microbus extends Vehiculo{
    public static final double PLUS_POR_PLAZA_MINIBUS = 5;
    private int numPLazas;


    public Microbus(String gama, String matricula, String combustible, int numPLazas) throws VehiculoException {
        super(gama, matricula, combustible);
        setNumPLazas(numPLazas);
    }

    public void setNumPLazas(int numPLazas) throws VehiculoException {
        if (numPLazas <= 0){
            throw new VehiculoException("No puede tener 0 o menos plazas");
        }
        this.numPLazas = numPLazas;
    }

    @Override
    public double calcularAlquilerVehiculo(int dias) {
        double precioFinal = super.calcularAlquilerVehiculo(dias);
        precioFinal += numPLazas * PLUS_POR_PLAZA_MINIBUS;
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Microbus{" +
                "numPLazas=" + numPLazas +
                super.toString()+'}';
    }
}
