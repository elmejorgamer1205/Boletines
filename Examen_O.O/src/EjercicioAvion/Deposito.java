package EjercicioAvion;

import Exceptions.AvionException;

public class Deposito {
    private double cantidadMax;
    private double cantidadAct;

    public Deposito(double cantidadMax, double cantidadAct) {
        this.cantidadMax = cantidadMax;
        this.cantidadAct = cantidadAct;
    }

    public double getCantidadAct() {
        return cantidadAct;
    }

     private void setCantidadAct(double cantidadAct) {
        this.cantidadAct = cantidadAct;
    }

    public double getCantidadMax() {
        return cantidadMax;
    }

    private void setCantidadMax(double cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public double rellenarDeposito(){
        if (cantidadAct < cantidadMax){
            cantidadAct = cantidadMax;
        }
        return cantidadMax;
    }
}
