package Boletin6_1.Ejercicio3.models;

import Boletin6_1.Ejercicio3.enums.TipoEnsenanza;

public class Alumno extends Persona{
    public Alumno(String nombre, int edad){
        super(nombre,edad, TipoEnsenanza.ALUMNO);
    }
}
