package Boletin7_1.Ejercicio9;

import io.MiEntradaSalida;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class Ejercicio9 {

    static void main(String[] args) {

        String nombreFichero = MiEntradaSalida.leerLinea("Introduce el nombre del fichero: ");


        Path path = Path.of("src", "Boletin7.1","Ejercicio9", nombreFichero);

        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            System.err.println("El fichero no existe o no es valido.");
            return;
        }
        try (Stream<String> lineas = Files.lines(path)){
            lineas.filter(l -> l.matches("/\\p{L}+\\s\\d{4}-[B-Z&&[^EIOU]]{3}"));

            Files.writeString(StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
