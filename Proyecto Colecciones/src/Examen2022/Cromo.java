package Examen2022;

import java.util.Objects;

// Declaramos la clase como 'abstract' porque un "Cromo" genérico no existe en la realidad.
// Solo existirán sus hijos (Jugador o Escudo). Esto impide que hagamos un 'new Cromo(...)' por error.
public abstract class Cromo {

    // Usamos 'final' para hacer que el cromo sea INMUTABLE.
    // Una vez que sale de fábrica (se construye), su identificador y su nombre no pueden cambiar nunca.
    private final int id;
    private final String nombre;

    // Constructor base. Aunque la clase sea abstracta, necesita un constructor
    // para que las clases hijas (Jugador y Escudo) puedan llamarlo usando super()
    public Cromo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters para poder leer los datos desde fuera de la clase (como en la clase Mazo)
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // --- MÉTODOS FUNDAMENTALES PARA LAS COLECCIONES (HashMap, HashSet...) ---

    // Sobrescribimos equals() para enseñar a Java cómo comparar dos cromos.
    // El enunciado decía: "dos cromos son iguales si su identificador es igual".
    @Override
    public boolean equals(Object o) {
        // 1. Optimización: Si estamos comparando exactamente el mismo espacio en memoria, son iguales.
        if (this == o) return true;

        // 2. Seguridad: Si el objeto a comparar es nulo o ni siquiera es de la familia Cromo, no son iguales.
        if (o == null || getClass() != o.getClass()) return false;

        // 3. Casteo: Convertimos el objeto genérico 'Object' a tipo 'Cromo' para poder leer su ID.
        Cromo cromo = (Cromo) o;

        // 4. La regla de oro: devolvemos true SOLO si los IDs coinciden.
        return id == cromo.id;
    }

    // La regla de Java exige que si modificas equals(), SIEMPRE debes modificar hashCode().
    // Genera un código numérico basado en el ID. Esto permite que el HashMap de la clase Mazo
    // guarde y busque los cromos a una velocidad ultrarrápida.
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Sobrescribimos toString() para que al imprimir el objeto por consola (System.out.println)
    // no salga un código de memoria raro, sino directamente el nombre del cromo.
    @Override
    public String toString() {
        return nombre;
    }
}