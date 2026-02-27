package Boletin6_1.Ejercicio7;

import exceptions.RecetaException;

import java.time.Duration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Receta implements Comparable<Receta>{

    private Duration tiempoDeElaboracion;
    private String nombre;
    Set<Ingrediente> ingredientes;
    LinkedList<String> pasos;
    Iterator<String> iterador = pasos.iterator();

    public Receta(String nombre, Duration tiempoDeElaboracion) {
        this.nombre = nombre;
        this.tiempoDeElaboracion = tiempoDeElaboracion;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public Duration getTiempoDeElaboracion() {
        return tiempoDeElaboracion;
    }

    /**
     * Metodo que recorre la lista de ingredientes en busca del ingrediente que buscas
     * @param nombreIngrediente
     * @return si está el ingrediente o no
     */
    public boolean necesitaIngrediente(String nombreIngrediente) {
        //bucle para recorer la lista de ingredientes
        for (Ingrediente ingrediente : ingredientes){
            //si el nombre del ingrediente ya está en la receta devuelve true
            if(nombreIngrediente.equalsIgnoreCase(ingrediente.getNombre())){
                return true;
            }
        }
        //si no lo está false
        return false;
    }

    public void annadirPaso(String paso) {
        pasos.add(paso);
    }

    /**
     * Metodo para añadir ingredientes a la lista de ingredientes
     * @param ingredienteNuevo
     */
    public void annadirIngrediente(Ingrediente ingredienteNuevo){
        boolean encontrado = false;
        //bucle para recorrer la lista de ingredientes uno a uno
        for(Ingrediente ingrediente: ingredientes){
            //si el nombre del ingrediente a añadir ya existia antes le sumas la cantidad en vez de duplicar el nombre
            if(ingrediente.getNombre().equalsIgnoreCase(ingredienteNuevo.getNombre())){
                ingrediente.setCantidad(ingrediente.getCantidad() + ingredienteNuevo.getCantidad());
                encontrado = true;
            }
        }
        //si el ingrediente no está lo añade a la lista de ingredientes
        if (!encontrado){
            ingredientes.add(ingredienteNuevo);
        }
    }

    /**
     * Metodo que borra el ingrediente de la lista de ingredientes y de los pasos de la receta
     * @param ingredienteABorrar
     * @throws RecetaException
     */
    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {
        //si el ingrediente que intentas borra no existe, lanzamos excepcion
        if (!ingredientes.contains(ingredienteABorrar)) {
            throw new RecetaException("No existe el ingrediente que quieres borrar en la receta");
        }
        //borrar ingrediente
        ingredientes.remove(ingredienteABorrar);

        //Mientras queden paso de la receta por leer en la lista
        while (iterador.hasNext()){
            String paso = iterador.next(); //extraemos el texto del paso actual
            //si el paso contiene el nombre del ingrediente, elimina el paso que contiene el nombre
            if (paso.contains(ingredienteABorrar.getNombre())) {
                iterador.remove();
            }
        }
    }

    /**
     * Metodo para añadir un paso detrás de otro existente.
     * @param pasoNuevo El texto del nuevo paso a insertar.
     * @param pasoExistente El texto del paso detrás del cual se insertará.
     * @throws RecetaException Si el pasoExistente no se encuentra en la receta.
     */
    public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
        int posicion = pasos.indexOf(pasoExistente);
        int posicionInsercion;

        //si el paso no existía anteriormente lanzamos excepción
        if (posicion == -1) {
            throw new RecetaException("El paso previo no existe en la receta");
        }
        /*
         * Al usar pasos.indexOf(), le estás pidiendo a la lista completa que busque el texto,
         * y al sumarle 1 calculas el hueco perfecto para el nuevo paso.
         */
        posicionInsercion = posicion + 1;

        // Insertamos el nuevo paso en su posición
        pasos.add(posicionInsercion, pasoNuevo);
    }

    public Ingrediente devolverIngrediente(String nombre) throws RecetaException {
        for (Ingrediente ing : ingredientes) {
            if (ing.getNombre().equalsIgnoreCase(nombre)) {
                return ing;
            }
        }
        throw new RecetaException("Ese ingrediente no esta en la receta. \n");
    }

    @Override
    public int compareTo(Receta o) {
        return this.getTiempoDeElaboracion().compareTo(o.getTiempoDeElaboracion());
    }

}
