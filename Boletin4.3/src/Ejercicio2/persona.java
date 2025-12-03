package Ejercicio2;

import Exceptions.personaException;

import java.util.Arrays;

public class persona {

    private String nombre;
    private int[] mensajesRecibidos = new int[5];
    private int[] mensajesEnviados = new int[5];

    public persona(){
        setNombre(nombre);
        setMensajesEnviados(mensajesEnviados);
        setMensajesRecibidos(mensajesRecibidos);
    }

    public void setMensajesEnviados(int[] mensajesEnviados) {
        this.mensajesEnviados = mensajesEnviados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMensajesRecibidos(int[] mensajesRecibidos) {
        this.mensajesRecibidos = mensajesRecibidos;
    }

    public void enivarMensaje() throws personaException{

    }

    public void borrarMensajeEnvidadoMásAntiguo() throws personaException{

    }

    public void borrarMensajeRecibidoMásAntiguo() throws personaException{

    }

    public void agregarMensajeEnviado(int mensaje) {
        mensajesEnviados = Arrays.copyOf(mensajesEnviados, mensajesEnviados.length + 1);
        mensajesEnviados[mensajesEnviados.length - 1] = mensaje;
    }

}

