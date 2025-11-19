package Ejercicio3;

import Exceptions.CuentaExceptions;
import utils.MiEntradaSalida;

public class MáquinaCafé {

    public int vasos;
    public int cafe;
    public int leche;
    public double monedero;

    public MáquinaCafé() {
        vasos = 80;
        leche = 50;
        cafe = 50;
        monedero = 83.75;
    }

    public int getCafe() {
        return cafe;
    }

    public void setCafe(int cafe) {
        this.cafe = cafe;
    }

    public int getLeche() {
        return leche;
    }

    public void setLeche(int leche) {
        this.leche = leche;
    }

    public double getMonedero() {
        return monedero;
    }

    public void setMonedero(double monedero) {
        this.monedero = monedero;
    }

    public int getVasos() {
        return vasos;
    }

    public void setVasos(int vasos) {
        this.vasos = vasos;
    }

    @Override
    public String toString() {
        return "MáquinaCafé{" +
                "cafe=" + cafe +
                ", vasos=" + vasos +
                ", leche=" + leche +
                ", monedero=" + monedero +
                '}';
    }

    public void colsultarMaquina(){

    }

    public void rellenarMaquina(int cafe, int leche, int vasos) throws CuentaExceptions{
        if (cafe >= 50 && leche >= 50 && vasos >= 80){
            throw new CuentaExceptions("Ya está lleno");
        }

    }

    public void vaciarMonedero(int monedero) throws CuentaExceptions{
        if(monedero >= 0){
            throw new CuentaExceptions("No te queda dinero en el monedero");
        }
    }

    public void servicio(int cafe, int leche, int vasos, int cantidadCafe, int cantidadLeche, int cantidadVasos) throws CuentaExceptions {

    }


}
