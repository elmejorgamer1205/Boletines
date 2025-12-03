package Ejercicio2;

import java.time.LocalDate;

public class mensaje {

    private String asunto;
    private String cuerpo;
    private LocalDate fechaDeEnvio;
    private persona destinatario;
    private persona remitente;

    public mensaje(){
        setAsunto(asunto);
        setCuerpo(cuerpo);
        setFechaDeEnvio(fechaDeEnvio);
        setDestinatario(destinatario);
        setRemitente(remitente);
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setFechaDeEnvio(LocalDate fechaDeEnvio) {
        this.fechaDeEnvio = fechaDeEnvio;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public void setRemitente(persona remitente) {
        this.remitente = remitente;
    }

    public void setDestinatario(persona destinatario) {
        this.destinatario = destinatario;
    }
}
