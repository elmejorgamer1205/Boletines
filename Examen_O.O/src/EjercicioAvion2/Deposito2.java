package EjercicioAvion2;


import Exceptions.AvionException;

public class Deposito2 {
    public final double CAPACIDAD_MAX;
    private double capacidadActual;

    public Deposito(double capacidadMax, double capacidadActual) throws AvionException {
        if (capacidadMax <= 0){
            throw new AvionException("Capacidad máxima invalida");
        }
        this.CAPACIDAD_MAX = capacidadMax;
        setCapacidadActual(capacidadActual);
    }

    public void setCapacidadActual(double capacidadActual) throws AvionException {
        if (capacidadActual < 0){
            throw new AvionException("La capacidad actual...");
        }
        if (capacidadActual > CAPACIDAD_MAX){throw new AvionException("La capacidad actual maxima invalida");}
        this.capacidadActual = capacidadActual;
    }

    public double getCapacidadActual() {
        return capacidadActual;
    }

    @Override
    public String toString() {
        return "Deposito{" +
                "capacidadActual=" + capacidadActual +
                '}';
    }


}
