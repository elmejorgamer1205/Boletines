package Boletin6_1.Agencia_De_Viajes;

import java.util.Collection;
import java.util.TreeSet;

public class Ruta{
    private String nombre;
    private String destinoFinal;
    private TreeSet<String> paradas;

    public Ruta(String nombre, String destinoFinal) {
        this.nombre = nombre;
        this.destinoFinal = destinoFinal;

    }

    public String getDestinoFinal() {
        return destinoFinal;
    }

    public void setDestinoFinal(String destinoFinal) {
        this.destinoFinal = destinoFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public TreeSet<String> getParadas() {
        return this.paradas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void annadirParada(String parada){
        if(!paradas.add(parada)){
            System.out.println("La parada '" + parada + "' ya existe en esta ruta.");
        }
    }

    public void eliminarParada(String parada){
        if(!paradas.remove(parada)){
            throw new IllegalArgumentException("No se puede eliminar la parada que dices porque no existe esa parada");
        }
    }

    @Override
    public String toString(){
        return "Rutas{" +
                "nombre='" + nombre + '\'' +
                ", parada='" + paradas + '\'' +
                ", destino final='" + destinoFinal + '\'' +
                '}';
    }
}
