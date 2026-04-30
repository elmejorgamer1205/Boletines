package Ejercicio3_MiniBoletin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

    // Recuerda el 'public'
    public static void main(String[] args) {

        // 1. Creamos el objeto secundario (la Dirección)
        Direccion d1 = new Direccion("Calle España", "Isla Cristina", "21410");

        // 2. Creamos el objeto principal (el Usuario), pasándole la Dirección por parámetro.
        // Esto es "Composición". En el JSON, la dirección aparecerá como un sub-bloque anidado.
        Usuario u1 = new Usuario(d1, "csimseq1205@g.educaand.es", "*******", "Carlos");

        // 🌟 LA MAGIA DE @Expose ACTIVADA
        // Al añadir .excludeFieldsWithoutExposeAnnotation(), Gson ignorará cualquier atributo
        // de Usuario o de Direccion que no tenga explícitamente la anotación @Expose encima.
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();

        Path path = Path.of("src/main/java/Ejercicio3_MiniBoletin/usuario.json");

        try {
            // Fase de Serialización (Escritura)
            String json = gson.toJson(u1);
            Files.writeString(path, json, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            // Fase de Deserialización (Lectura segura con try-with-resources)
            try (BufferedReader lector = Files.newBufferedReader(path)) {
                Usuario usuario1 = gson.fromJson(lector, Usuario.class);

                // Imprime el usuario reconstruido.
                // 💡 Para que esto se vea bien, asegúrate de que tu clase Usuario tiene un toString()
                // que a su vez llame a direccion.toString()
                System.out.println(usuario1.toString());
            }

        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}