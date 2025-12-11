package EjercicioAvion;

import Exceptions.AvionException;

import java.time.LocalDate;
import java.time.Period;

public class Avion {
    private final static int NUM_REGISTROS = 5;
    private String marca;
    private String modelo;
    private double consumo;
    private Deposito deposito;
    private Registros[] registros;

    public Avion(double consumo, String marca, String modelo, Deposito deposito) {
        this.consumo = consumo;
        this.marca = marca;
        this.modelo = modelo;
        this.deposito = deposito;
        this.registros = new Registros[NUM_REGISTROS];
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean estaListo(){
        try{
            Registros ultimaRevision = getUltimaRevision();
            if (!getUltimaRevision().isEstado()||ultimaRevision.getFecha().plus(ultimaRevision.getPeriodoDeValidez()).isBefore(LocalDate.now())) {
                return false;
            }
            else {
                return true;
            }
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

    public boolean puedeHacerElRecorrido(double distancia){

    }
}
