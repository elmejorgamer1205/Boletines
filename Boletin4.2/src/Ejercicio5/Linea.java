package Ejercicio5;

import Exceptions.LineaException;

public class Linea {
    private Punto puntoA;
    private Punto puntoB;

    public Linea() {
        this.puntoA = new Punto(0, 0);
        this.puntoB = new Punto(0, 0);
    }

    public Linea(Punto puntoA, Punto puntoB) {
        setPuntoA(puntoA);
        setPuntoB(puntoB);
    }

    public Punto getPuntoA() {
        return puntoA;
    }

    public void setPuntoA(Punto puntoA) {
        this.puntoA = puntoA;
    }

    public Punto getPuntoB() {
        return puntoB;
    }

    public void setPuntoB(Punto puntoB) {
        this.puntoB = puntoB;
    }


    public void moverEjeX(double distancia){
        puntoA.setCordenadaX(puntoA.getCordenadaX()+distancia);
        puntoB.setCordenadaX(puntoB.getCordenadaX()+distancia);
    }

    public void moverEjeY(double distancia){
        puntoA.setCordenadaY(puntoA.getCordenadaY()+distancia);
        puntoB.setCordenadaY(puntoB.getCordenadaY()+distancia);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Linea{");
        sb.append("puntoA=").append(puntoA);
        sb.append(", puntoB=").append(puntoB);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Linea linea = (Linea) o;
        return puntoA.equals(linea.puntoA) && puntoB.equals(linea.puntoB);
    }

    @Override
    public int hashCode() {
        int result = puntoA.hashCode();
        result = 31 * result + puntoB.hashCode();
        return result;
    }

    public void comprobarSiEsPunto() throws LineaException{
        if (puntoA.getCordenadaX()==puntoB.getCordenadaX() && puntoA.getCordenadaY()==puntoB.getCordenadaY()){
            throw new LineaException("\nError: No es una linea.\n");
        }
    }
}
