package Boletin7_1.Ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ejercicio4 {
    static void main(String[] args) {

        Path fichero = Path.of("src/Boletin7_1/Ejercicio3/salidaEj3.txt");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String linea;

            while ((linea = br.readLine()) != null && !linea.equalsIgnoreCase("fin")){
                Files.writeString(fichero, linea, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
