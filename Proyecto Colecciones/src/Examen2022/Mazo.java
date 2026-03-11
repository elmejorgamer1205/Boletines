package Examen2022;

import Examen2022.exceptions.MazoException;

import java.util.*;
import java.util.stream.Collectors;

public class Mazo {

    // Colección principal: asocia cada Cromo único (Clave) con la cantidad de copias que tenemos (Valor)
    private final Map<Cromo, Integer> cromos;

    // Constructor 1: Permite crear un mazo pasándole un mapa que ya existe
    public Mazo(Map<Cromo, Integer> cromos) {
        this.cromos = cromos;
    }

    // Constructor 2: Crea un mazo vacío listo para empezar a jugar
    public Mazo() {
        this.cromos = new HashMap<>();
    }

    // Devuelve una lista simple con todos los cromos únicos que tenemos (sin sus cantidades)
    public List<Cromo> getLista() {
        return new ArrayList<>(cromos.keySet());
    }

    // Añade un cromo al mazo incrementando su contador
    public void addCromo(Cromo c) {
        // compute: Si el cromo no existe (v == null), lo añade con valor 1. Si existe, le suma 1 al valor actual (v + 1).
        cromos.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
    }

    // Intercambia un cromo nuestro por otro nuevo
    public void intercambiar(Cromo cromoParaCambiar, Cromo cromoDelOtro) throws MazoException {
        // 1. Programación defensiva: evitamos que el programa falle si nos pasan nulos
        if (cromoParaCambiar == null || cromoDelOtro == null) {
            throw new MazoException("Error: Uno de los cromos indicados no existe en la base de datos.");
        }

        // 2. Comprobamos si realmente tenemos el cromo que queremos dar
        if (!cromos.containsKey(cromoParaCambiar)) {
            throw new MazoException("No posees el cromo " + cromoParaCambiar.getNombre() + " para intercambiar.");
        }

        // 3. Restamos 1 a la cantidad de nuestro cromo. Si al restar nos da 0 (es decir, devolvemos null en la lambda), el cromo se borra del mapa.
        cromos.computeIfPresent(cromoParaCambiar, (c, v) -> v > 1 ? v - 1 : null);

        // 4. Añadimos el cromo que hemos recibido
        addCromo(cromoDelOtro);
    }

    // Devuelve la cantidad de cromos ÚNICOS (sin contar repeticiones)
    public int contarDiferentes() {
        return cromos.size();
    }

    // Une los cromos de otro mazo con el nuestro, sumando las cantidades
    public void mezclar(Mazo m2) {
        // Recorremos el mapa del otro mazo. Por cada cromo y su cantidad, lo fusionamos con el nuestro.
        m2.cromos.forEach((cromo, cantidad) -> {
            // merge: Si no tenemos el cromo, lo añade con esa cantidad. Si lo tenemos, suma las cantidades usando Integer::sum
            cromos.merge(cromo, cantidad, Integer::sum);
        });
    }

    // Devuelve una lista con todos los cromos (escudo o jugadores) que pertenezcan a un equipo concreto
    public List<Cromo> cromosDeUnEquipo(String equipoMostrar) {
        return cromos.keySet().stream()
                .filter(cromo -> {
                    // Si el cromo es un Jugador, comprobamos su atributo 'equipo'
                    if (cromo instanceof Jugador jugador) {
                        return jugador.getEquipo().equalsIgnoreCase(equipoMostrar); // ¡Corregido!
                    } else {
                        // Si es un Escudo (o genérico), usamos su propio nombre
                        return cromo.getNombre().equalsIgnoreCase(equipoMostrar);
                    }
                })
                .toList(); // Equivalente moderno a collect(Collectors.toList())
    }

    // Extra: Devuelve los nombres de los equipos de los que tenemos todos los jugadores y el escudo
    public List<String> equipoCompleto() {
        return cromos.keySet().stream()
                .filter(cromo -> cromo instanceof Escudo)   // 1. Filtramos solo los escudos
                .map(cromo -> (Escudo) cromo)               // 2. Los transformamos (casteo) a Escudo
                .filter(escudo -> {
                    // 3. Contamos cuántos jugadores únicos tenemos de ese equipo exacto
                    long jugadoresQueTenemos = cromosDeUnEquipo(escudo.getNombre()).stream()
                            .filter(c -> c instanceof Jugador)
                            .count();

                    // 4. Comprobamos si la cantidad coincide con los jugadores requeridos por el escudo
                    return jugadoresQueTenemos == escudo.getNumeroJugadores();
                })
                .map(Escudo::getNombre)                     // 5. Nos quedamos solo con los nombres de los equipos completados
                .collect(Collectors.toList());              // 6. Lo empaquetamos en una lista
    }

    // Devuelve todos los cromos ordenados: primero los escudos y luego alfabéticamente
    public List<Cromo> ordenar() {
        return cromos.keySet().stream()
                .sorted((c1, c2) -> {
                    // 1. Asignamos "pesos" para ordenar por tipo (Escudos = 0 van antes que Jugadores = 1)
                    int tipo1 = (c1 instanceof Escudo) ? 0 : 1;
                    int tipo2 = (c2 instanceof Escudo) ? 0 : 1;

                    // Si son de distinto tipo, ordenamos por ese peso (el escudo gana)
                    if (tipo1 != tipo2) {
                        return Integer.compare(tipo1, tipo2);
                    }

                    // 2. Si son del mismo tipo, resolvemos el empate por orden alfabético
                    return c1.getNombre().compareToIgnoreCase(c2.getNombre());
                })
                .collect(Collectors.toList());
    }

    // Calcula la altura media de los jugadores de un equipo específico
    public OptionalDouble alturaMedia(String equipoAltura) {
        return cromos.keySet().stream()
                .filter(cromo -> cromo instanceof Jugador)                             // 1. Solo jugadores
                .map(cromo -> (Jugador) cromo)                                         // 2. Casteamos a Jugador
                .filter(jugador -> jugador.getEquipo().equalsIgnoreCase(equipoAltura)) // 3. Solo del equipo pedido
                .mapToInt(Jugador::getAltura)                                          // 4. Extraemos sus alturas como números (IntStream)
                .average();                                                            // 5. Calculamos la media (devuelve OptionalDouble por si no hubiera jugadores)
    }
}