package Ejercicio1;

import Exceptions.cartaException;

public class carta {

    private String palo;
    private String número;


    public carta() {
        setNúmero(número);
        setPalo(palo);
    }

    public String getNúmero() {
        return número;
    }

    public void setNúmero(String número) {
        this.número = número;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public void crearBaraja(){

    }

    public void mostrarBaraja() throws cartaException{
        System.out.println(toString());
    }

    public void barajarBaraja() throws cartaException{

    }

    public void repartirCartas() throws cartaException{

    }

    public void cartasRestantes() throws cartaException{

    }

    @Override

    public String toString(){
        return "";
    }
}
