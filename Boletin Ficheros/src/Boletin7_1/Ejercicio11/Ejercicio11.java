package Boletin7_1.Ejercicio11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio11 {
    // Como siempre, acuérdate del 'public' para el main
    static void main(String[] args) {
        try {
            crearDirectorios();
        } catch (Ejercicio11Exception e) { // Captura tu excepción personalizada
            System.out.printf("%s \n", e.getMessage());
        }
    }

    // Se declara que el método puede lanzar tu excepción personalizada
    public static void crearDirectorios() throws Ejercicio11Exception {

        // 🌟 ¡ESPECTACULAR! Uso de Regex con "Grupos de Captura con Nombre" (?<nombre_grupo>).
        // Esto hace que extraer los datos después sea mil veces más fácil y legible.
        Pattern patron = Pattern.compile("^(?<nombre>\\p{Lu}\\p{Ll}+)\\s(?<apellido1>\\p{Lu}\\p{Ll}+)\\s(?<apellido2>\\p{Lu}\\p{Ll}+)\\s(?<curso>[1-6]º[A-Z]+)$");

        Path rutaArchivoContenido = Path.of("src/Boletin7_1/ejercicio11/Ejercicio11.txt");

        // Cláusula de guarda muy robusta: verifica que exista, sea un archivo y se pueda leer.
        if (Files.notExists(rutaArchivoContenido) || !Files.isRegularFile(rutaArchivoContenido) || !Files.isReadable(rutaArchivoContenido)){
            throw new Ejercicio11Exception("Moisés friki galaxy, la película (No es posible acceder al archivo, o no es un archivo de texto o no se puede leer)");
        }

        boolean todasLasLineasCumplenElFormato = false;

        // PRIMERA LECTURA: Se abre el archivo para validar que TODAS las líneas sean correctas.
        try(Stream<String> lineas = Files.lines(rutaArchivoContenido)){
            todasLasLineasCumplenElFormato = lineas.allMatch(l -> l.matches(patron.pattern()));
        } catch (IOException e){
            System.out.printf("%s \n",e.getMessage());
        }

        // Si una sola línea falla, abortamos la misión lanzando la excepción.
        if (!todasLasLineasCumplenElFormato){
            throw new Ejercicio11Exception("El archivo no cumple el patrón");
        }

        // SEGUNDA LECTURA: Volvemos a abrir el archivo.
        // (Nota: Los Streams en Java se "consumen", por eso tienes que volver a abrirlo. ¡Bien resuelto!)
        try(Stream<String> lineas = Files.lines(rutaArchivoContenido)){
            lineas.map(patron::matcher) // Convierte cada línea (String) en un objeto Matcher
                    .filter(Matcher::find) // Se asegura de que el matcher haya encontrado el patrón
                    .forEach(m -> {
                        // Extraemos los datos usando los nombres que definiste en la Regex. ¡Súper limpio!
                        String nombre = m.group("nombre");
                        String apellido1 = m.group("apellido1");
                        String apellido2 = m.group("apellido2");
                        String curso = m.group("curso");

                        try {
                            // Crea toda la ruta de carpetas de golpe (ej: 1ºA/PerezGarciaJuan)
                            Files.createDirectories(Path.of("src/ejercicio11/salida", curso, apellido1+apellido2+nombre));
                        } catch (IOException e) {
                            System.out.printf("%s \n", e.getMessage());
                        }
                    });
        } catch (IOException e){
            System.out.printf("%s \n",e.getMessage());
        }
    }
}