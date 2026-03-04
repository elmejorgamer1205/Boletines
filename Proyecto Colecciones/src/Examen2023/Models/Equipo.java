package Examen2023.Models;

import Examen2023.Exception.EquipoException;

import java.util.HashSet;
import java.util.Objects;

public class Equipo {

    private String nombreEquipo;
    private HashSet<Jugador> conjuntoJugadores;

    public Equipo(HashSet<Jugador> conjuntoJugadores, String nombre) {
        this.conjuntoJugadores = conjuntoJugadores;
        this.nombreEquipo = nombre;
    }

    public HashSet<Jugador> getConjuntoJugadores() {
        return conjuntoJugadores;
    }

    public String getNombre() {
        return nombreEquipo;
    }

    public void setNombre(String nombre) {
        this.nombreEquipo = nombre;
    }

    public boolean annadirJugador(Jugador j) throws EquipoException {
        if(!conjuntoJugadores.add(j)){
            throw new EquipoException("El jugador " + j.getNombre() + " ya existe en este equipo.");
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Si es el mismo objeto en memoria
        if (o == null || getClass() != o.getClass()) return false; // Si es nulo o de otra clase
        Equipo equipo = (Equipo) o; // Convertimos el objeto a Equipo
        return Objects.equals(nombreEquipo, equipo.nombreEquipo); // Comparamos solo el nombre
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreEquipo); // Generamos el código basado solo en el nombre
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombreEquipo).append(":\n"); // Nombre del equipo

        // Recorremos los jugadores
        for (Jugador j : conjuntoJugadores) {
            sb.append(j.toString()).append("\n");
        }
        return sb.toString();
    }
}
