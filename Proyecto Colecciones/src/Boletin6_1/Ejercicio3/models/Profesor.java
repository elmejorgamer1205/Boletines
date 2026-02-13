package Boletin6_1.Ejercicio3.models;

import Boletin6_1.Ejercicio3.enums.TipoEnsenanza;

public class Profesor extends Persona{
    public Profesor(String nombre, int edad){
        super(nombre,edad, TipoEnsenanza.PROFESOR);
    }
}

