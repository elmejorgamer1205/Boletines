package Boletin6_1.Ejercicio7;

import exceptions.RecetaException;

import java.util.HashSet;

public class Receta {

    HashSet<Ingrediente> ingredientes;

    public boolean nombreRepetido(String nombreIngrediente) {
        for (Ingrediente ingrediente : ingredientes){
            if(nombreIngrediente.equalsIgnoreCase(ingrediente.getNombre())){
                return true;
            }
        }
        return false;
    }

    public void annadirIngrediente(Ingrediente ingredienteNuevo){
        boolean encontrado = false;
        for(Ingrediente ingrediente: ingredientes){
            if(ingrediente.getNombre().equalsIgnoreCase(ingredienteNuevo.getNombre())){
                ingrediente.setCantidad(ingrediente.getCantidad() + ingredienteNuevo.getCantidad());
                encontrado = true;
            }
        }
        if (!encontrado){
            ingredientes.add(ingredienteNuevo);
        }
    }


}
