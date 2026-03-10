package Examen2022;

import java.util.Objects;

public abstract class Cromo{

    private final int id;
    private final String nombre;

    public Cromo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Si es exactamente el mismo objeto en memoria
        if (o == null || getClass() != o.getClass()) return false; // Si son de clases distintas
        Cromo cromo = (Cromo) o;
        return id == cromo.id; // La regla de oro: comparamos solo el ID
    }

    // Si modificamos equals(), SIEMPRE debemos modificar hashCode() usando el mismo atributo
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Sobrescribimos toString para que al imprimir un cromo se lea bien su nombre
    @Override
    public String toString() {
        return nombre;
    }
}
