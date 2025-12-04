package Ejercicio2;

import java.time.LocalDateTime;

public class mensaje {
    private String asunto;
    private String cuerpo;
    private LocalDateTime fechaDeEnvio;
    private persona destinatario;
    private persona remitente;

    public mensaje() {
        this.asunto = getAsunto();
        this.cuerpo = getCuerpo();
        this.fechaDeEnvio = getFechaDeEnvio();
        this.remitente = getRemitente();
        this.destinatario = getDestinatario();
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public persona getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(persona destinatario) {
        this.destinatario = destinatario;
    }

    public LocalDateTime getFechaDeEnvio() {
        return fechaDeEnvio;
    }

    public void setFechaDeEnvio(LocalDateTime fechaDeEnvio) {
        this.fechaDeEnvio = fechaDeEnvio;
    }

    public persona getRemitente() {
        return remitente;
    }

    public void setRemitente(persona remitente) {
        this.remitente = remitente;
    }
}
