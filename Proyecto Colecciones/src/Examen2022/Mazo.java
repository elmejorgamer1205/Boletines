package Examen2022;

import Examen2022.exceptions.MazoException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mazo {

    private Map<Cromo, Integer> cromos;
    
    public Mazo() {
        this.cromos = new HashMap<>();
    }

    public void addCromo(Cromo c) {
        cromos.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
    }

    public void intercambiar(Cromo cromoParaCambiar, Cromo cromoDelOtro) throws MazoException {
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
    }

    public boolean alturaMedia(String equipoAltura) {
    }

    public Arrays ordenar() {
    }

    public Arrays equipoCompleto() {
    }
}