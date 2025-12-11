package Avion2;


import EjercicioAvion.Deposito;
import EjercicioAvion2.Revision2;
import Exceptions.AvionException;

public class Avion2 {
    private String marca;
    private String modelo;
    private int consumo;
    private Deposito deposito;
    private Revision2[]  revisiones;

    public Avion2(String marca, String modelo, int consumo, Deposito deposito) {
        this.marca = marca;
        this.modelo = modelo;
        this.consumo = consumo;
        this.deposito = deposito;
        this.revisiones = new Revision2[5];
    }

    private int indiceUltimaRevision() throws AvionException {
        for (int i = revisiones.length -1; i >= 0; i--){
            if (revisiones[i]!=null){
                return i;
            }
        }
        throw new AvionException("No se encontro ninguna revisión");
    }

    public void añadirRevision(Revision2 r) throws AvionException {
        for (int i = 0; i < revisiones.length; i++){
            if (revisiones[i]==null){
                revisiones[i] = r;
                return;
            }
        }
        throw new AvionException("No se encontro ninguna revision");
    }

    public boolean puedeVolar(double distancia){
        if (!estaListo()||distancia*consumo > deposito.getCapacidadActual()||distancia<0){
            return false;
        }
        return true;
    }

    private boolean estaListo(){
        try {
            return revisiones[indiceUltimaRevision()].isEstado();
        } catch (AvionException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Avion2{" +
                "modelo='" + modelo + '\'' +
                ", deposito=" + deposito +
                ", marca='" + marca + '\'' +
                ", ¿es valido? "+ estaListo()+
                '}';

    }
}