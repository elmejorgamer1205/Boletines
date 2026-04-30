package Ejercicio1_MiniBoletin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

    // Añadido el 'public' para que la JVM reconozca el punto de entrada
    public static void main(String[] args) {

        // 1. Instanciamos nuestro POJO con un clasicazo de los videojuegos
        Videojuego videojuego = new Videojuego(1993, "id Software", "DOOM" );

        // 2. Preparamos Gson con el formato "bonito" (saltos de línea y sangrías)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // 3. Definimos la ruta de nuestro archivo
        Path path = Path.of("src/main/java/Ejercicio1_MiniBoletin/Videojuego.json");

        try {
            // ==========================================
            // FASE 1: SERIALIZACIÓN (Objeto -> JSON)
            // ==========================================

            // Convertimos el objeto Videojuego a una cadena de texto en formato JSON
            String json = gson.toJson(videojuego);

            // Escribimos el JSON en el disco.
            // 💡 TRUCO: Añado TRUNCATE_EXISTING. Si ejecutas esto varias veces y cambias los datos,
            // te aseguras de que el archivo se borra y se reescribe limpio en lugar de mezclarse.
            Files.writeString(path, json, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);


            // ==========================================
            // FASE 2: DESERIALIZACIÓN (JSON -> Objeto)
            // ==========================================

            // ⚠️ CUIDADO AQUÍ: Files.newBufferedReader(path) abre un flujo de lectura hacia el disco.
            // Tal y como está escrito, ese flujo nunca se cierra. Lo ideal sería meterlo en un
            // try-with-resources o al menos guardarlo en una variable para hacerle un .close().

            // Lee el archivo JSON y, gracias a "Videojuego.class", Gson sabe qué "molde" usar
            // para reconstruir el objeto original en la memoria RAM.
            Videojuego videojuego1 = gson.fromJson(Files.newBufferedReader(path), Videojuego.class);

            // Comprobamos que la magia ha funcionado imprimiendo el objeto reconstruido.
            // 💡 TRUCO: System.out.println() ya llama automáticamente a .toString() por debajo,
            // así que puedes escribir simplemente System.out.println(videojuego1);
            System.out.println(videojuego1.toString());

        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida: " + e.getMessage());
        }
    }
}