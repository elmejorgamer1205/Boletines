package Boletin6_1.Agencia_De_Viajes;

import java.util.Collection;
import java.util.TreeSet;

public class Ruta {

    // --- ATRIBUTOS ---
    private String nombre;
    private String destinoFinal;

    // Se usa un TreeSet porque almacena elementos sin permitir duplicados
    // y además los mantiene ordenados automáticamente (alfabéticamente para los Strings).
    private TreeSet<String> paradas;

    // --- CONSTRUCTOR ---
    /**
     * Crea una nueva ruta con un nombre y un destino final.
     */
    public Ruta(String nombre, String destinoFinal) {
        this.nombre = nombre;
        this.destinoFinal = destinoFinal;
        // ¡CORRECCIÓN AQUÍ! Es vital inicializar el TreeSet para poder añadirle elementos después.
        this.paradas = new TreeSet<>();
    }

    // --- GETTERS Y SETTERS ---
    // Métodos para acceder y modificar los atributos encapsulados (private)

    public String getDestinoFinal() {
        return destinoFinal;
    }

    public void setDestinoFinal(String destinoFinal) {
        this.destinoFinal = destinoFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TreeSet<String> getParadas() {
        return this.paradas;
    }

    // --- MÉTODOS DE COMPORTAMIENTO ---
    /**
     * Añade una nueva parada a la ruta.
     */
    public void annadirParada(String parada){
        // El método .add() de los Set devuelve 'false' si el elemento ya existía.
        // Aprovechamos esto para avisar al usuario sin necesidad de recorrer la lista.
        if(!paradas.add(parada)){
            System.out.println("La parada '" + parada + "' ya existe en esta ruta.");
        }
    }

    /**
     * Elimina una parada existente en la ruta.
     */
    public void eliminarParada(String parada){
        // El método .remove() de los Set devuelve 'false' si el elemento no se encontró.
        // Si no se encuentra, lanzamos una excepción para interrumpir y avisar del error.
        if(!paradas.remove(parada)){
            throw new IllegalArgumentException("No se puede eliminar la parada que dices porque no existe esa parada");
        }
    }

    // --- MÉTODOS SOBRESCRITOS ---

    /**
     * Sobrescribe el método toString de la clase Object para devolver
     * una representación en formato texto legible de los datos de la Ruta.
     */
    @Override
    public String toString(){
        return "Rutas{" +
                "nombre='" + nombre + '\'' +
                ", parada='" + paradas + '\'' + // Imprimirá el contenido del TreeSet entre corchetes, ej: [Madrid, París]
                ", destino final='" + destinoFinal + '\'' +
                '}';
    }
}
