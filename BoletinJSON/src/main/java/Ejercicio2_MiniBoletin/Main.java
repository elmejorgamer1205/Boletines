package Ejercicio2_MiniBoletin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Main {

    // Añadido el 'public'
    public static void main(String[] args) {

        // Creamos la lista y la llenamos de estudiantes
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        Estudiante e1 = new Estudiante("1º DAM", "Álvaro", 9.8);
        Estudiante e2 = new Estudiante("1º DAM", "Javier", 7.3);
        Estudiante e3 = new Estudiante("1º DAM", "Carlos", 6.6);

        estudiantes.add(e1);
        estudiantes.add(e2);
        estudiantes.add(e3);

        // Preparamos Gson con formato legible
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path path = Path.of("src/main/java/Ejercicio2_MiniBoletin/Estudiantes.json");

        try {
            // ==========================================
            // FASE 1: SERIALIZAR LA LISTA A JSON
            // ==========================================
            String json = gson.toJson(estudiantes);

            // 💡 Añado TRUNCATE_EXISTING para que no se mezclen datos si lo ejecutas varias veces
            Files.writeString(path, json, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            // ==========================================
            // FASE 2: DESERIALIZAR DE JSON A LISTA
            // ==========================================

            // 🌟 ¡EL CONCEPTO CLAVE DEL EJERCICIO!
            // Debido al "Borrado de Tipos" en Java, cuando la aplicación compila, olvida que esto era un
            // ArrayList<Estudiante> y solo ve un ArrayList genérico. Si le pasamos Estudiante.class a Gson,
            // fallaría porque es una lista, no un solo estudiante.
            // Con TypeToken<ArrayList<Estudiante>>(){}.getType() capturamos el tipo exacto en tiempo de ejecución.
            Type tipoMiLista = new TypeToken<ArrayList<Estudiante>>(){}.getType();

            // Metemos la lectura en un try-with-resources para cerrar el archivo correctamente
            try (BufferedReader lector = Files.newBufferedReader(path)) {

                // Usamos el 'tipoMiLista' que hemos fabricado en lugar del típico '.class'
                ArrayList<Estudiante> estudiantes1 = gson.fromJson(lector, tipoMiLista);

                // Imprimimos el resultado usando una Referencia a Método (Method Reference). ¡Muy elegante!
                estudiantes1.forEach(System.out::println);
            }

        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}