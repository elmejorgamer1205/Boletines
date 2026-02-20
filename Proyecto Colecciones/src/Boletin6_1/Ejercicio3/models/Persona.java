package Boletin6_1.Ejercicio3.models;

import Boletin6_1.Ejercicio3.enums.TipoEnsenanza;
import Boletin6_1.Ejercicio3.exceptions.PersonaException;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {

    private String nombre;
    private int edad;
    TipoEnsenanza tipoEnsenanza;
    List<Mensaje> buzon;

    public Persona(String nombre, int edad, TipoEnsenanza tipoEnsenanza){
        this.nombre = nombre;
        this.edad = edad;
        this.tipoEnsenanza = tipoEnsenanza;
        this.buzon = new ArrayList<>();
    }

    public void setBuzon(List<Mensaje> buzon) {
        this.buzon = buzon;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoEnsenanza(TipoEnsenanza tipoEnsenanza) {
        this.tipoEnsenanza = tipoEnsenanza;
    }

    public TipoEnsenanza getTipoEnsenanza() {
        return tipoEnsenanza;
    }

    public void enviarMensaje(Persona destinatario, String texto) throws PersonaException{
        if(this.tipoEnsenanza == TipoEnsenanza.ALUMNO && this.edad < 18 && destinatario.getTipoEnsenanza() != TipoEnsenanza.PROFESOR){
          throw new PersonaException("Error: Los alumnos menores solo pueden mandar mensajes a profesores");
        }
        /**Mensaje m = new Mensaje(this, texto);
        destinatario.recibirMensaje(m);
         **/
    }

}
