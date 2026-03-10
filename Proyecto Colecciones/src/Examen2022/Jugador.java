package Examen2022;

import java.util.HashSet;

public class Jugador extends Cromo {

    private int equipo;
    private String altura;

    public Jugador(int id, String nombre, String altura, int equipo) {
        super(id, nombre);
        this.altura = altura;
        this.equipo = equipo;
    }

    public String getAltura() {
        return altura;
    }

    public int getEquipo() {
        return equipo;
    }

    @Override
    public String toString() {
        return "Jugador: " + getNombre() + " (" + equipo + ")";
    }
}
