package Ejercicio3;

import Exceptions.CuentaExceptions;
import Exceptions.MaquinaCafeException;
import utils.MiEntradaSalida;

public class MáquinaCafé {

    public int vasos;
    public int cafe;
    public int leche;
    public double monedero;
    public final double PRECIOCAFE = 1;
    public final double PRECIOLECHE = 0.8;
    public final double PRECIOCAFECONLECHE = 1.5;

    public MáquinaCafé() {
        setVasos(80);
        setLeche(50);
        setCafe(50);
        setMonedero(10);
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

    public void colsultarMaquina() {
        System.out.println(toString());
    }

    public void rellenarMaquina(int cafe, int leche, int vasos) throws CuentaExceptions {
        setVasos(80);
        setLeche(50);
        setCafe(50);

    }

    public void vaciarMonedero(int monedero) throws CuentaExceptions {
        this.monedero -= this.monedero;
    }
}



