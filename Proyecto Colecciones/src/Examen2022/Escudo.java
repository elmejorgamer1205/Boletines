package Examen2022;

import java.util.HashSet;

public class Escudo extends Cromo{

    private final int numeroJugadores;
    private final int annoDeFundacion;

    public Escudo(int id, String nombre, int annoDeFundacion, int numJugadores) {
        super(id, nombre);
        this.annoDeFundacion = annoDeFundacion;
        this.numeroJugadores = numJugadores;
    }

    public int getAnnoDeFundacion() {
        return annoDeFundacion;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    @Override
    public String toString() {
        return "Escudo: " + getNombre();
    }


}
