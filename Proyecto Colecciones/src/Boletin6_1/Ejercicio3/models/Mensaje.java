package Boletin6_1.Ejercicio3.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje implements Comparable<Mensaje> {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public String getFormattedDetails(int numero){
        return "Mensaje " + numero + ": De:" + remitente.getNombre() +
                " ... " + fechaHora.format(FORMATO);
    }

    @Override
    public int compareTo(Mensaje o) {
        return 0;
    }
}
