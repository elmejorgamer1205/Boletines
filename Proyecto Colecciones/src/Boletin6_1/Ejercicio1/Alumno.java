package Boletin6_1.Ejercicio1;

import java.util.ArrayList;
import java.util.Collection;

public class Alumno {

    private String nombre, dni;

    public Alumno(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;
        return nombre.equals(alumno.nombre) && dni.equals(alumno.dni);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + dni.hashCode();
        return result;
    }
}
