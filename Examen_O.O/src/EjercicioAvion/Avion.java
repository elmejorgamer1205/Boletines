package EjercicioAvion;

import Exceptions.AvionException;

import java.time.LocalDate;
import java.util.Arrays;

public class Avion {
    private final static int NUM_REGISTROS = 5;
    private String marca;
    private String modelo;
    private double consumo;
    private Deposito combustible;
    private Registros[] registros;

    public Avion(String marca, String modelo, double consumo, Deposito combustible)throws AvionException {
        this.marca = marca;
        this.modelo = modelo;
        setConsumo(consumo);
        this.combustible = combustible;
        this.registros = new Registros[NUM_REGISTROS];
    }

    public void setConsumo(double consumo)throws AvionException {
        if (consumo <= 0) {
            throw new AvionException("El consumo no puede ser negativo o 0");
        }
        this.consumo = consumo;
    }

    public boolean estaListo(){
        try{
            Registros ultimaRevision = getUltimaRevision();
            return getUltimaRevision().isEstado() && !ultimaRevision.getFecha().plus(ultimaRevision.getPeriodoValidez()).isBefore(LocalDate.now());
        }catch (AvionException e){
            return false;
        }

    }

    private Registros getUltimaRevision()throws AvionException{
        for (int i = registros.length -1; i <= 0; i--) {
            if (registros[i] != null){
                return registros[i];
            }
        }
        throw new AvionException("ERROR: El avión no tiene registros de revisiones realizadas actualmente");
    }

    @Override
    public String toString() {
        return "Avion{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", consumo=" + consumo +
                ", combustible=" + combustible +
                ", ¿Listo para viajar? " + Arrays.toString(registros) +
                '}';
    }
}
