package Boletin7_1.Ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ejercicio4 {
    // Sigue faltando el 'public' (public static void main) para poder ejecutar la clase.
    static void main(String[] args) {

        // Se define la ruta del archivo de salida usando NIO (Path).
        // Curiosamente, apunta al mismo archivo que se generó en el Ejercicio 3.
        Path fichero = Path.of("src/Boletin7_1/Ejercicio3/salidaEj3.txt");

        // Bloque try-with-resources.
        // Prepara la lectura de datos desde el teclado (System.in).
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String linea;

            // Bucle que lee por teclado hasta que se escriba "fin" (ignorando mayúsculas/minúsculas).
            while ((linea = br.readLine()) != null && !linea.equalsIgnoreCase("fin")){

                // Utiliza la API NIO para escribir la cadena directamente en el archivo.
                // StandardOpenOption.CREATE: Si el archivo no existe, lo crea.
                // StandardOpenOption.APPEND: Si ya existe, añade el texto al final.
                // ⚠️ NOTA IMPORTANTE: br.readLine() quita el salto de línea al leer, y writeString no lo añade por defecto.
                // Si escribes varias palabras, se pegarán todas en la misma línea (ej: "holamundoprueba").
                // Para arreglarlo, deberías concatenar un salto: linea + System.lineSeparator()
                Files.writeString(fichero, linea, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }

        } catch (IOException e) {
            // Captura cualquier error de entrada/salida y muestra el mensaje.
            System.out.println(e.getMessage());
        }
    }
}