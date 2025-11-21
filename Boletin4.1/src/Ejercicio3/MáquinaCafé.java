package Ejercicio3;

import Exceptions.MaquinaCafeException;

public class MáquinaCafé {

    private int vasos;
    private int cafe;
    private int leche;
    private double monedero;
    public static final double PRECIOCAFE = 1.0;
    public static final double PRECIOLECHE = 0.8;
    public static final double PRECIOCAFECONLECHE = 1.5;

    public MáquinaCafé() {
        setVasos(80);
        setLeche(50);
        setCafe(50);
        setMonedero(10.0);
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

    public void consultarMaquina() {
        System.out.println(toString());
    }

    public void rellenarMaquina() throws MaquinaCafeException {
        if (cafe < 0 || leche < 0 || vasos < 0) {
            throw new MaquinaCafeException("Los valores para rellenar no pueden ser negativos.");
        }
        setCafe(cafe);
        setLeche(leche);
        setVasos(vasos);
    }

    public void ingresarDinero(double cantidad) throws MaquinaCafeException {
        if (cantidad <= 0) {
            throw new MaquinaCafeException("La cantidad a ingresar debe ser positiva.");
        }
        monedero += cantidad;
    }


    public double cafeSolo(double dineroIntroducido) throws MaquinaCafeException {
        if (vasos < 1){
            throw new MaquinaCafeException("No hay vasos disponibles.");
        }
        if (cafe < 1){
            throw new MaquinaCafeException("No hay café suficiente.");
        }
        if(dineroIntroducido < PRECIOCAFE){
            throw new MaquinaCafeException("No has introducido suficiente dinero");
        }
        double cambio = dineroIntroducido - PRECIOCAFE;
        if (cambio > monedero){
            throw new MaquinaCafeException("No disponemos de cambio suficiente.");
        }
        vasos--;
        cafe--;
        monedero += PRECIOCAFE;

        return cambio;
    }

    public double leche(double dineroIntroducido) throws MaquinaCafeException {
        if (vasos < 1){
            throw new MaquinaCafeException("No hay vasos disponibles.");
        }
        if (leche < 1){
            throw new MaquinaCafeException("No hay leche suficiente.");
        }
        if(dineroIntroducido < PRECIOCAFE){
            throw new MaquinaCafeException("No has introducido suficiente dinero");
        }
        double cambio = dineroIntroducido - PRECIOLECHE;
        if (cambio > monedero){
            throw new MaquinaCafeException("No disponemos de cambio suficiente.");
        }
        vasos--;
        leche--;
        monedero += PRECIOLECHE;

        return cambio;
    }

    public double cafeConLeche( double dineroIntroducido) throws MaquinaCafeException {
        if (vasos < 1){
            throw new MaquinaCafeException("No hay vasos disponibles.");
        }
        if (cafe < 1){
            throw new MaquinaCafeException("No hay café suficiente.");
        }
        if (leche < 1){
            throw new MaquinaCafeException("No hay leche suficiente.");
        }
        if (dineroIntroducido < PRECIOCAFE){
            throw new MaquinaCafeException("No has introducido suficiente dinero");
        }
        double cambio = dineroIntroducido - PRECIOLECHE;
        if (cambio > monedero){
            throw new MaquinaCafeException("No disponemos de cambio suficiente.");
        }
        vasos--;
        cafe--;
        leche--;
        monedero += PRECIOCAFECONLECHE;

        return cambio;
    }
}



