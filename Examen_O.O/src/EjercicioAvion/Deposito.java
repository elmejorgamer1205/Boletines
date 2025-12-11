package EjercicioAvion;

import Exceptions.AvionException;

public class Deposito {
    private final int CAPACIDAD_MAX;
    private double cantidadActual;

    public Deposito(int capacidadMaxima, double cantidadActual) throws AvionException {
        if (capacidadMaxima <= 0 ) {throw new AvionException("La capacidad maxima debe ser mayor a 0");}
        this.CAPACIDAD_MAX = capacidadMaxima;
        setCantidadActual(cantidadActual);
    }

    private void setCantidadActual(double cantidadActual) throws AvionException {
        if (cantidadActual<0){
            throw new AvionException("La cantidad debe ser mayor a 0");
        }
        if (cantidadActual > CAPACIDAD_MAX){
            throw new AvionException("No puedes meter esa cantidad, no cabe en el deposito");
        }
        this.cantidadActual = cantidadActual;
    }

    @Override
    public String toString() {
        return "DepositoCombustible{" +
                "cantidadActual=" + cantidadActual +
                '}';
    }

    public double getCantidadActual() {
        return cantidadActual;
    }
}
