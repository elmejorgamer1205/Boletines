package Ejercicio3_MiniBoletin;


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

public class Main {
    static void main(String[] args) {

        Direccion d1 = new Direccion("Calle España","Isla Cristina","21410");

        Usuario u1 = new Usuario(d1,"csimseq1205@g.educaand.es","*******","Carlos");


        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

        Path path = Path.of("src/main/java/Ejercicio3_MiniBoletin/usuario.json");

        try {
            String json = gson.toJson(u1);
            Files.writeString(path, json, StandardOpenOption.CREATE);
            Usuario usuario1 = gson.fromJson(Files.newBufferedReader(path), Usuario.class);
            System.out.println(usuario1.toString());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
