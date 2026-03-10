package Examen2022;

import java.util.HashSet;

public class Escudo extends Cromo{

    private int numJugadores;
    private int annoDeFundacion;

    public Escudo(int id, String nombre, int annoDeFundacion, int numJugadores) {
        super(id, nombre);
        this.annoDeFundacion = annoDeFundacion;
        this.numJugadores = numJugadores;
    }

    public int getAnnoDeFundacion() {
        return annoDeFundacion;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    @Override
    public String toString() {
        return "Escudo: " + getNombre();
    }


}
