package Examen2022;

import Examen2022.exceptions.MazoException;

import java.util.*;
import java.util.stream.Collectors;

public class Mazo {

    private final Map<Cromo, Integer> cromos;

    public Mazo(Map<Cromo, Integer> cromos) {
        this.cromos = cromos;
    }

    public Mazo() {
        this.cromos = new HashMap<>();
    }

    public List<Cromo> getLista() {
        return new java.util.ArrayList<>(cromos.keySet());
    }

    public void addCromo(Cromo c) {
        cromos.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
    }

    public void intercambiar(Cromo cromoParaCambiar, Cromo cromoDelOtro) throws MazoException {
        if (cromoParaCambiar == null || cromoDelOtro == null) {
            throw new MazoException("Error: Uno de los cromos indicados no existe en la base de datos.");
        }

        if (!cromos.containsKey(cromoParaCambiar)) {
            throw new MazoException("No posees el cromo " + cromoParaCambiar.getNombre() + " para intercambiar.");
        }

        cromos.computeIfPresent(cromoParaCambiar, (c, v) -> v > 1 ? v - 1 : null);

        addCromo(cromoDelOtro);
    }

    public int contarDiferentes() {
        return cromos.size();
    }

    public void mezclar(Mazo m2) {
        m2.cromos.forEach((cromo, cantidad) -> {
            cromos.merge(cromo, cantidad, Integer::sum);
        });
    }

    public List<Cromo> cromosDeUnEquipo(String equipoMostrar) {
        return cromos.keySet().stream().
                filter(cromo -> {
                    if (cromo instanceof Jugador jugador) {
                        return jugador.getNombre().equalsIgnoreCase(equipoMostrar);
                    } else {
                        return cromo.getNombre().equalsIgnoreCase(equipoMostrar);
                    }
                }).toList();
        }

    public List<String> equipoCompleto() {
        return cromos.keySet().stream()
                .filter(cromo -> cromo instanceof Escudo) // Buscamos entre nuestros escudos
                .map(cromo -> (Escudo) cromo)
                .filter(escudo -> {
                    // Reutilizamos el metodo que ya creamos para sacar los cromos de ese equipo
                    long jugadoresQueTenemos = cromosDeUnEquipo(escudo.getNombre()).stream()
                            .filter(c -> c instanceof Jugador)
                            .count();

                    // ¿Tenemos tantos jugadores únicos como pide el escudo?
                    return jugadoresQueTenemos == escudo.getNumeroJugadores();
                })
                .map(Escudo::getNombre) // Devolvemos solo el nombre del equipo
                .collect(Collectors.toList());
    }

    public List<Cromo> ordenar() {
        return cromos.keySet().stream()
                .sorted((c1, c2) -> {
                    // 1. Prioridad por tipo (Escudo = 0, Jugador = 1 para que los escudos vayan antes)
                    int tipo1 = (c1 instanceof Escudo) ? 0 : 1;
                    int tipo2 = (c2 instanceof Escudo) ? 0 : 1;

                    if (tipo1 != tipo2) {
                        return Integer.compare(tipo1, tipo2);
                    }

                    // 2. Si son del mismo tipo, orden alfabético por nombre
                    return c1.getNombre().compareToIgnoreCase(c2.getNombre());
                })
                .collect(Collectors.toList());
    }

    public OptionalDouble alturaMedia(String equipoAltura) {
        return cromos.keySet().stream()
                .filter(cromo -> cromo instanceof Jugador) // Solo queremos jugadores
                .map(cromo -> (Jugador) cromo)             // Lo tratamos como Jugador
                .filter(jugador -> jugador.getEquipo().equalsIgnoreCase(equipoAltura)) // De ese equipo
                .mapToInt(Jugador::getAltura)              // Sacamos el número de su altura
                .average();                                // Calcula la media automáticamente
    }
}





