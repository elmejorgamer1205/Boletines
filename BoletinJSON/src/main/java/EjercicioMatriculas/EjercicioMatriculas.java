package EjercicioMatriculas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class EjercicioMatriculas {

    // Añadido modificador public
    public static void main(String[] args) {

        // Rutas de entrada (el txt) y salida (el json)
        Path p = Path.of("src/main/java/EjercicioMatriculas/matriculas_espanolas_10.txt");
        Path pSalida = Path.of("src/main/java/EjercicioMatriculas/lista_matriculas_salidas.json");

        // Gson configurado para que el JSON quede bonito y legible
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // 🌟 PATRÓN MEJORADO
        // ^ y $ para asegurar que la línea solo contenga esto y nada más.
        // (?<numeros>\d{4}): Captura exactamente 4 dígitos y los llama "numeros".
        // (?<letras>[B-Z&&[^EIOUQ]]{3}): Captura 3 consonantes españolas (sin vocales ni la Q) y las llama "letras".
        Pattern patron = Pattern.compile("^(?<numeros>\\d{4})\\s(?<letras>[B-Z&&[^EIOUQ]]{3})$");

        // try-with-resources para asegurar el cierre del Stream del archivo
        try (Stream<String> lineas = Files.lines(p)) {

            // 🌟 PIPELINE FUNCIONAL (Magia pura con Streams)
            List<Matricula> matriculas = lineas
                    .map(patron::matcher)         // 1. Convierte cada línea de texto en un "evaluador" (Matcher)
                    .filter(Matcher::find)        // 2. Deja pasar solo las líneas que cumplan el patrón
                    .map(m -> {                   // 3. Por cada línea válida, extraemos los datos...
                        String numeros = m.group("numeros");
                        String letras = m.group("letras");

                        // ... y construimos un objeto Matricula fresco.
                        return new Matricula(numeros, letras);

                    })
                    .toList(); // 4. Recoge todos los objetos Matricula creados y los empaqueta en una Lista Inmutable.

            // Serializamos la lista completa de matrículas a formato JSON
            String json = gson.toJson(matriculas);

            // Guardamos en el archivo.
            // 💡 Añado TRUNCATE_EXISTING para sobrescribir en caso de que ejecutes el programa varias veces.
            Files.writeString(pSalida, json, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Proceso finalizado. Archivo JSON generado con éxito.");

        } catch (IOException e) {
            System.out.printf("Error de E/S: %s", e.getMessage());
        }
    }
}