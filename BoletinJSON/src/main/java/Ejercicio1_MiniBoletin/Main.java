package Ejercicio1_MiniBoletin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    static void main(String[] args) {

        Videojuego videojuego = new Videojuego(1993, "id Software", "DOOM" );

        Gson gson = new GsonBuilder().create();

        Path path = Path.of("src/main/java/Ejercicio1_MiniBoletin/Videojuego.json");

        try (BufferedReader r = Files.newBufferedReader(path)) {

            String json = gson.toJson(videojuego);
            Files.writeString(path, json);
            Videojuego videojuego1 = gson.fromJson(r, Videojuego.class);
            System.out.println(videojuego1.toString());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
