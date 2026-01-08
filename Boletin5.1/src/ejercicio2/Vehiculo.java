package ejercicio2;

import Exceptions.VehiculoException;

public abstract class Vehiculo {
    private Gama gama;
    private final String MATRICULA;
    private final Combustible TIPO_DE_COMBUSTIBLE;


    public Vehiculo(String  gama, String matricula, String combustible) throws VehiculoException{
        setGama(gama);
        this.MATRICULA = matricula;
        try {
            this.TIPO_DE_COMBUSTIBLE = Combustible.valueOf(combustible.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new VehiculoException("Ese combustible no es válido");
        }
    }

    public void setGama(String gama) throws VehiculoException {
        try {
            this.gama = Gama.valueOf(gama.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new VehiculoException("Esa gama no es valida");
        }

    }

    public Combustible getTIPO_DE_COMBUSTIBLE() {
        return TIPO_DE_COMBUSTIBLE;
    }

    public Gama getGama() {
        return gama;
    }

    @Override
    public String toString() {
        return " "+
                "gama=" + gama +
                ", matricula=" + MATRICULA + '\'' +
                ", tipoDeCombustible=" + TIPO_DE_COMBUSTIBLE;
    }

    public double calcularAlquilerVehiculo(int dias){
        double precioFinal = 0;
        precioFinal += getGama().getPRECIO()*dias;
        precioFinal += getTIPO_DE_COMBUSTIBLE().getPrecio()*dias;
        return precioFinal;
    }
}
