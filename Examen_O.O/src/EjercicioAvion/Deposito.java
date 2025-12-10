package EjercicioAvion;

import Exceptions.AvionException;

public class Deposito {
    private double cantidadMax;
    private double cantidadAct;

    public Deposito(){

    }

    public int rellenarDeposito(double cantidadMax, double cantidadAct)throws AvionException {
        if(cantidadAct>cantidadMax || cantidadAct<0){
            throw new AvionException("ERROR: No se puede realizar esta acción (cantidad invalida de conbustible)");
        }
        if (cantidadAct < cantidadMax){
            cantidadAct = cantidadMax;
        }
        return (int) cantidadMax;
    }
}
