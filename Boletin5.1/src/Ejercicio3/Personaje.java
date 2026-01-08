package Ejercicio3;

import Exceptions.PersonajeException;

public class Personaje {
    private String nombre;
    private Raza raza;
    private int fuerza;
    private int inteligencia;
    private int VIDA_MAX;
    private int vidaActu;

    public Personaje(String nombre, String[] raza, int fuerza, int inteligencia, int vidaMax, int vidaActu)throws PersonajeException {
       this.nombre = nombre;
       setRaza(raza);
       setFuerza(fuerza);
       setInteligencia(inteligencia);
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }
}
