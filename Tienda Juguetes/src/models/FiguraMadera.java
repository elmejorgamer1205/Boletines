package models;

import exceptions.JugueteException;
import interfaces.Apilable;

public class FiguraMadera extends JugueteMadera implements Apilable {
    private String color;
    private int numLados;

    public FiguraMadera(String nombre, String marca, String origen, int anoTala, String color, int numLados) throws JugueteException {
        super(nombre, marca, origen, anoTala);
        this.color = color;
        this.setNumLados(numLados);
    }

    public int getNumLados() {
        return numLados;
    }

    private void setNumLados(int numLados) throws JugueteException {
        if (numLados < 1) {
            throw new JugueteException("No puedes tener una figura sin lados");
        }
        this.numLados = numLados;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void apilar(Juguete a) throws JugueteException {
        Apilable.super.apilar(a);
        System.out.println("Se ha apilado " + this.getNombre() + " sobre " + a.getNombre());

    }

    @Override
    public String toString() {
        return this.getNombre() + " " + color + " de " + numLados + " lados";
    }

}
