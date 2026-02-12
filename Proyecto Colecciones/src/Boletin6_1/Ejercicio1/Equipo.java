package Boletin6_1.Ejercicio1;

import exceptions.EquipoException;

import java.util.*;

public class Equipo {
    private String nombre;
    private Set<Alumno> alumnos;

    public Equipo(String nombre){
        this.nombre = nombre;
        alumnos = new HashSet<>();
    }

    public void addAlumno(Alumno a)throws EquipoException{
        if (!alumnos.add(a)){
            throw new EquipoException("No se pudo añadir al equipo");
        }
    }

    public void borrarAlumno(Alumno a) throws EquipoException{
        if(!alumnos.remove(a)){
            throw new EquipoException("El alumno no pertenece al equipo");
        }
    }

    public Alumno buscarAlumno(Alumno a){
        if (!alumnos.contains(a)){
            return null;
        }
        return a;
    }

    public List<Alumno> devolverLista(){
        return new ArrayList<>(alumnos);
    }

    public Equipo unirEquipos(Equipo a){
        Set<Alumno> union = new HashSet<>();
        union.addAll(alumnos);
        union.addAll(a.alumnos);
        Equipo resultante = new Equipo("Union FC");
        resultante.alumnos = union;
        return resultante;
    }

    public Equipo interseccionEquipos(Equipo a){

    }
}
