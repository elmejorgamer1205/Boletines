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
    static void main(String[] args) {

        Path p = Path.of("src/main/java/EjercicioMatriculas/matriculas_espanolas_10.txt");
        Path pSalida = Path.of("src/main/java/EjercicioMatriculas/lista_matriculas_salidas.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Pattern patron = Pattern.compile("^(?<numeros>\\d{4})\\s(?<letras>[B-Z&&[^EIOUQ]]{3})$");

        try (Stream<String> lineas = Files.lines(p)) {

            List<Matricula> matriculas =  lineas.map(patron::matcher)
                    .filter(Matcher::find)
                    .map(m -> {
                        String numeros = m.group("numeros");
                        String letras = m.group("letras");

                        return new Matricula(numeros,letras);

                    }).toList();

            String json = gson.toJson(matriculas);

            Files.writeString(pSalida, json, StandardOpenOption.CREATE);

        } catch (IOException e) {
            System.out.printf("%s", e.getMessage());
        }
    }
}
