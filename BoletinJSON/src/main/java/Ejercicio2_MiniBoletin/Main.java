package Ejercicio2_MiniBoletin;

import Ejercicio1_MiniBoletin.Videojuego;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {

        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        Estudiante e1 = new Estudiante("1º DAM", "Álvaro", 9.8);
        Estudiante e2 = new Estudiante("1º DAM", "Javier", 7.3);
        Estudiante e3 = new Estudiante("1º DAM", "Carlos", 6.6);

        estudiantes.add(e1);
        estudiantes.add(e2);
        estudiantes.add(e3);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path path = Path.of("src/main/java/Ejercicio2_MiniBoletin/Estudiantes.json");

        try {
            String json = gson.toJson(estudiantes);
            Files.writeString(path, json, StandardOpenOption.CREATE);

            Type tipoMiLista = new TypeToken<ArrayList<Estudiante>>(){}.getType();

            ArrayList<Estudiante> estudiantes1 = gson.fromJson(Files.newBufferedReader(path), tipoMiLista);

            estudiantes1.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
