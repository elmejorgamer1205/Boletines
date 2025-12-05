package Ejercicio2;

import Exceptions.personaException;

import java.time.LocalDateTime;

public class persona {

    private String nombre;
    private mensaje[] mensajesRecibidos = new mensaje[5];
    private mensaje[] mensajesEnviados = new mensaje[5];

    public persona() {
        setNombre(nombre);
        setMensajesEnviados(mensajesEnviados);
        setMensajesRecibidos(mensajesRecibidos);
    }

    public void setMensajesEnviados(mensaje[] mensajesEnviados) {
        this.mensajesEnviados = mensajesEnviados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMensajesRecibidos(mensaje[] mensajesRecibidos) {
        this.mensajesRecibidos = mensajesRecibidos;
    }

    public void enivarMensaje(String asunto, String cuerpo, persona remitente) throws personaException {
        if (asunto == null || asunto.isBlank() || cuerpo == null || cuerpo.isBlank() || remitente == null) {
            throw new personaException("Error: Al mensaje le falta información");
        }
        if (estaLLenoEnvidado()) {
            throw new personaException("Error: el buzóne está lleno");
        }
        if (estaLlenoRecibido(remitente)) {
            throw new personaException("Error: el buzón del remitente está lleno");
        }


        mensaje m = new mensaje(asunto, cuerpo, this, remitente, LocalDateTime.now());

        for (int i = 0; i < mensajesEnviados.length; i++) {
            if (mensajesEnviados[i] == null) {
                mensajesEnviados[i] = m;
                break;
            }
        }

        for (int i = 0; i < mensajesRecibidos.length; i++) {
            if (mensajesRecibidos[i] == null) {
                mensajesRecibidos[i] = m;
                break;
            }
        }
    }


    public boolean estaLlenoRecibido(persona remitente) {
        for (int i = 0; i < mensajesRecibidos.length; i++) {
            if (mensajesRecibidos[i] == null) {
                return false;
            }
        }
        return true;
    }

    public boolean estaLLenoEnvidado() {
        for (int i = 0; i < mensajesEnviados.length; i++) {
            if (mensajesEnviados[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void borrarMensajeEnvidadoMasAntiguo() {
        for (int i = 0; i < mensajesEnviados.length - 1 && mensajesEnviados[i] != null; i++) {
            mensajesEnviados[i] = mensajesEnviados[i + 1];
        }
        mensajesEnviados[mensajesEnviados.length - 1] = null;
    }

    public void borrarMensajeRecibidoMasAntiguo() throws personaException {
        for (int i = 0; i < mensajesRecibidos.length - 1 && mensajesRecibidos[i] != null; i++) {
            mensajesRecibidos[i] = mensajesRecibidos[i + 1];
        }
        mensajesRecibidos[mensajesRecibidos.length - 1] = null;
    }
}


